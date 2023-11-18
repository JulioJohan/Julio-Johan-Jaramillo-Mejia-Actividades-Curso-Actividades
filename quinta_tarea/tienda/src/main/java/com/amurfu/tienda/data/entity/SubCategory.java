package com.amurfu.tienda.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_category",nullable = false)
    private Integer idSubCategory;

    @Column(name = "name_sub_category",length = 150, unique = true,nullable = false)
    private String nameSubCategory;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
