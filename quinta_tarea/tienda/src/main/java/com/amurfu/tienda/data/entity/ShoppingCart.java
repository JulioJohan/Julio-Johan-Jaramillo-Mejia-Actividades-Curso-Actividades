package com.amurfu.tienda.data.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping_cart",nullable = false)
    private Integer idShoppingCarty;

    @Column(name = "subtotal",nullable = false)
    private BigDecimal subtotal;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user",nullable = false)
    private User user;

    @OneToMany(mappedBy = "shoppingCart")
    @JsonBackReference
    private List<Product> products;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    @PrePersist
    private void createdAtPre(){
        createdAt = new Date();
    }
}
