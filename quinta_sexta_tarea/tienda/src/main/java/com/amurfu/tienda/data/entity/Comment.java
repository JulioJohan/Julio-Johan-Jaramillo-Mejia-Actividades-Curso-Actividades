package com.amurfu.tienda.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Integer idComment;
    @Column(name = "description",length = 500)
    private String description;
    @Column(name = "img",length = 1000)
    private String img;

    @ManyToOne()
    @JoinColumn(name = "id_product")
    private Product product;


}
