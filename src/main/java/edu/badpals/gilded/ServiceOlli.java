package edu.badpals.gilded;
import java.util.Optional;

import edu.badpals.gilded.dominio.*;
import jakarta.enterprise.context.ApplicationScoped;

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
}
