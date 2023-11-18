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

    @EmbeddedId
    private TransactionProductId idTransactionProductId;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "total",nullable = false)
    private BigDecimal total;

    @MapsId("idTransaction")
    @ManyToOne
    @JoinColumn(name = "id_transaction",nullable = false)
    private Transaction transaction;

    @MapsId("idProduct")
    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false)
    private Product product;

}
