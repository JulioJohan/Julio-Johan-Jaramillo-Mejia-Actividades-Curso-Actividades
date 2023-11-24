package com.amurfu.tienda.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer idAddress;

    @Column(name = "full_name",length = 300,nullable = false)
    private String fullName;

    @Column(name = "phone",length = 10,nullable = false)
    private Long phone;

    @Column(name = "postal_code",length = 10,nullable = false)
    private String postalCode;

    @Column(name = "country",length = 100,nullable = false)
    private String country;

    @Column(name = "estate",length = 100,nullable = false)
    private String estate;

    @Column(name = "city",length = 200,nullable = false)
    private String city;

    @Column(name = "street",length = 100,nullable = false)
    private String street;

    @Column(name = "outer_number",length = 5,nullable = false)
    private String outerNumber;

    @Column(name = "inner_number",length = 5,nullable = true)
    private String innerNumber;

    @Column(name = "address_references",length = 500,nullable = false)
    private String addressReferences;

    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    private void createdAtPre(){
        createdAt = new Date();
    }

}
