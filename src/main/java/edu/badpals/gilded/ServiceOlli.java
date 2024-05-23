package edu.badpals.gilded;
import java.util.Optional;

import edu.badpals.gilded.dominio.*;
public class ServiceOlli {
    ServiceOlli (){}
    
    public Item cargaItem(String nombre){
        Optional<Item> item = Item.findByIdOptional(nombre);
        return item.isPresent() ? item.get() : new Item(); 
    }
}
