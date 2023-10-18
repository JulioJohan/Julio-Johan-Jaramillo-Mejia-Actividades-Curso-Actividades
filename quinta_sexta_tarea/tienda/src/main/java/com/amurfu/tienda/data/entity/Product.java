package com.amurfu.tienda.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product",nullable = false)
    private Integer idProduct;

    @Column(name = "name_product",nullable = false,length = 200)
    private String nameProduct;

    @Column(name = "description",nullable = false,length = 5000)
    private String description;

    @Column(name = "serial",nullable = false,length = 100,unique = true)
    private String serial;

    @Column(name = "status",nullable = false, length = 12)
    private String status;

    @Column(name = "stock",nullable = false,length = 30)
    private Integer stock;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_category",nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_sub_category",nullable = false)
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_shopping_cart",nullable = true)
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "product")
    private List<Review> reviews;

    @PrePersist
    private void createdAtPre(){
        createdAt = new Date();
    }

}
