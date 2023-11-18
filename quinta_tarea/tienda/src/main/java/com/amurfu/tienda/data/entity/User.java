package com.amurfu.tienda.data.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "first_name",length = 100,nullable = false)
    private String firstName;

    @Column(name = "middle_name",length = 100,nullable = false)
    private String middleName;

    @Column(name = "last_name",length = 100,nullable = false)
    private String lastName;

    @Column(name = "second_last_name",length = 100,nullable = false)
    private String secondLastName;

    @Column(name = "email",length = 255, nullable = false,unique = true)
    private String email;

    @Column(name = "password",length = 255,nullable = false)
    private String password;

    @Column(name = "role", length = 10,nullable = false)
    private String role;

    @Column(name = "phone",length = 10,nullable = true)
    private Long phone;

    @Column(name = "avatar",length = 1000,nullable = true)
    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user")
    @JsonBackReference
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "id_shopping_cart",nullable = true)
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user")
    private List<Transaction> transactions;


    @PrePersist
    private void createdAtPre(){
        createdAt = new Date();
    }




}
