package com.amurfu.tienda.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_form_payment")
    private FormPayment formPayment;

    @OneToMany(mappedBy = "transaction",cascade = CascadeType.ALL)
    private List<TransactionProduct> transactionProducts;

    @PrePersist
    private void dateTransactionPre(){
        dateTransaction = new Date();
    }

}
