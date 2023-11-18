package com.amurfu.tienda.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "form_payment")
public class FormPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form_payment")
    private Integer idFormPayment;

    @Column(name = "name",length = 45,nullable = false)
    private String name;

    @Column(name = "description",length = 100,nullable = false)
    private String description;

    @OneToMany(mappedBy = "formPayment")
    private List<Transaction> transactions;




}
