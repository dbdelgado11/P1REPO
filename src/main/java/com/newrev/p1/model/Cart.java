package com.newrev.p1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
//@Component
@Entity
@Table(name = "cart")
@NoArgsConstructor
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

   /* @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/

    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;


    private int quantity;


    public Cart(Product product, Integer quantity, User user){
        System.out.println("Cart object created");
    }

    public String displayMessage(){
        return "This message is coming from Cart class";
    }
}
