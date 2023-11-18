package com.amurfu.tienda.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category",nullable = false)
    private Integer idCategory;

    @Column(name = "name_category",nullable = false,unique = true)
    private String nameCategory;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<SubCategory> subCategories;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> product;



}
