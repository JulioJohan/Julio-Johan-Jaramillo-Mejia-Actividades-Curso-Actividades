package com.amurfu.tienda.data.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TransactionProductTest {

    private TransactionProduct transactionProduct;

    private Transaction transaction;

    private Product product;


    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        transactionProduct = new TransactionProduct();
        transaction = new Transaction();
        product = new Product();
    }

    @Test
    void quantityTest(){
        assertNull(transactionProduct.getQuantity());
        transactionProduct.setQuantity(1);
        assertEquals(1,transactionProduct.getQuantity());
    }

    @Test
    void totalTest(){
        assertNull(transactionProduct.getTotal());
        transactionProduct.setTotal(new BigDecimal("1"));
        assertEquals(new BigDecimal("1"),transactionProduct.getTotal());
    }

    @Test
    void transactionTest(){
        assertNull(transactionProduct.getTransaction());
        transactionProduct.setTransaction(transaction);
        assertEquals(transaction,transactionProduct.getTransaction());
    }

    @Test
    void productTest(){
        assertNull(transactionProduct.getProduct());
        transactionProduct.setProduct(product);
        assertEquals(product,transactionProduct.getProduct());
    }


}
