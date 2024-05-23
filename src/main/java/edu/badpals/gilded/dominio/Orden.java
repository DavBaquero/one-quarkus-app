package edu.badpals.gilded.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_ordenes")
public class Orden extends PanacheEntityBase{
    @Id
        @Column(name = "ord_id")
        private Long id;
        
    @OneToOne
        @JoinColumn(name = "ord_user")
        private Usuaria user;
    @OneToOne
        @JoinColumn(name = "ord_item")
        private Item item;
    
    
    public Orden() {}

    
    public Orden(Usuaria user, Item item) {
        this.user = user;
        this.item = item;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuaria getUser() {
        return user;
    }
    public void setUser(Usuaria user) {
        this.user = user;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    


    

}
