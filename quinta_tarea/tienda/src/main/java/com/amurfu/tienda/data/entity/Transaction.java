package com.amurfu.tienda.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction",nullable = false)
    private Integer idTransaction;

    @Column(name = "date_transaction",nullable = false)
    private Date dateTransaction;

    @Column(name = "amount_products",nullable = false)
    private Integer amountProducts;

    @Column(name = "amount",nullable = false)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_form_payment")
    private FormPayment formPayment;

    @PrePersist
    private void dateTransactionPre(){
        dateTransaction = new Date();
    }

}
