package com.amurfu.tienda.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "transaction_product")
public class TransactionProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction_prodcut")
    private Integer idTransactionProduct;

    @Column(name = "cantidad",nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario",nullable = false)
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "id_transaction",nullable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false)
    private Product product;

}
