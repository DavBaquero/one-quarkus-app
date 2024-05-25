package edu.badpals.gilded;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;

import edu.badpals.gilded.dominio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ServiceOlli {
    ServiceOlli (){}
    
    public Item cargaItem(String nombre){
        Optional<Item> item = Item.findByIdOptional(nombre);
        return item.isPresent() ? item.get() : new Item(); 
    }

    public Usuaria cargaUsuaria(String nombre){
        Optional<Usuaria> user = Usuaria.findByIdOptional(nombre);
        return user.isPresent() ? user.get() : new Usuaria();
    }

    public List<Orden> cargaOrden(String nombre){
        return Orden.findByUserName(nombre);
    }

    @Transactional
    public Orden comanda(String nom_user, String nom_item){
        Orden orden = null;
        Optional<Usuaria> user = Usuaria.findByIdOptional(nom_user);
        Optional<Item> item = Item.findByIdOptional(nom_item);
        if (user.isPresent() && item.isPresent() && user.get().getDestreza() >= item.get().getQuality()){
            orden = new Orden(user.get(), item.get());
            orden.persist();
        }
        return orden;

    }

    @Transactional
    public List<Orden> comandaMultiple(String nom_user, List<String> productos){
        Optional<Usuaria> user = Usuaria.findByIdOptional(nom_user);
        if (user.isEmpty()){
            return Collections.emptyList();
        }

        List<Orden> ordenes = new ArrayList<Orden>();

        Orden orden = null;
        for(String producto: productos){
            orden = this.comanda(user.get().getNombre(), producto);
            if (orden != null){
                ordenes.add(orden);
            }
        }
        return ordenes;

    }
}
