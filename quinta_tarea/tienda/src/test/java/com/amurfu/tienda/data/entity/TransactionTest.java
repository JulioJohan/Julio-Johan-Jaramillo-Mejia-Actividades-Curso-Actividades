package com.amurfu.tienda.data.entity;

import com.amurfu.tienda.data.dto.TransactionDTO;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {

    private Transaction transaction;
    private User user;
    private FormPayment formPayment;
    private TransactionProduct transactionProduct;

    private Date date;
    private List<TransactionProduct> transactionProducts;


    private Validator validator;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        transaction = new Transaction();
        user = new User();
        date = new Date();
        formPayment = new FormPayment();
        transactionProduct = new TransactionProduct();
        transactionProducts = new ArrayList<>();
        transactionProducts.add(transactionProduct);
    }

    @Test
    void idTransactionTest(){
        assertNull(transaction.getIdTransaction());
        transaction.setIdTransaction(1);
        assertEquals(1, transaction.getIdTransaction());
    }

    @Test
    void userTest(){
        assertNull(transaction.getUser());
        transaction.setUser(user);
        assertEquals(user, transaction.getUser());
    }

    @Test
    void formPaymentTest(){
        assertNull(transaction.getFormPayment());
        transaction.setFormPayment(formPayment);
        assertEquals(formPayment, transaction.getFormPayment());
    }

    @Test
    void transactionProductsTest(){
        assertNull(transaction.getTransactionProducts());
        transaction.setTransactionProducts(transactionProducts);
        assertEquals(transactionProducts, transaction.getTransactionProducts());
    }

    @Test
    void dateTest(){
        assertNull(transaction.getDateTransaction());
        transaction.setDateTransaction(date);
        assertEquals(date, transaction.getDateTransaction());
    }
    
}
