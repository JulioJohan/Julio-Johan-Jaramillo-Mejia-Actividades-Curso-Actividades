package com.amurfu.tienda.data.entity;

import com.amurfu.tienda.data.dto.AddressDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class FormPaymentTest {

    private FormPayment formPayment;
    private Transaction transaction;

    private List<Transaction> transactions;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        formPayment = new FormPayment();
        transaction = new Transaction();
        transactions = new ArrayList<>();
        transactions.add(transaction);
    }

    @Test
    void idFormPaymentTest() {
        assertNull(formPayment.getIdFormPayment());
        formPayment.setIdFormPayment(1);
        assertEquals(1, formPayment.getIdFormPayment());
    }

    @Test
    void nameTest() {
        assertNull(formPayment.getName());
        formPayment.setName("Name");
        assertEquals("Name", formPayment.getName());
    }


    @Test
    void descriptionTest() {
        assertNull(formPayment.getDescription());
        formPayment.setDescription("Description");
        assertEquals("Description", formPayment.getDescription());
    }

    @Test
    void transactionsTest() {
        assertNull(formPayment.getTransactions());
        formPayment.setTransactions(transactions);
        assertEquals(transactions, formPayment.getTransactions());
    }


}
