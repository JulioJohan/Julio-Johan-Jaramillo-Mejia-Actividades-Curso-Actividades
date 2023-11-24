package com.amurfu.tienda.data.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TransactionProductIdTest {

    private TransactionProductId transactionProductId;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        transactionProductId = new TransactionProductId();
    }

    @Test
    void idTransaccionTest(){
        assertNull(transactionProductId.getIdTransaction());
        transactionProductId.setIdTransaction(1);
        assertEquals(1,transactionProductId.getIdTransaction());
    }
    @Test
    void idProductTest(){
        assertNull(transactionProductId.getIdProduct());
        transactionProductId.setIdProduct(1);
        assertEquals(1,transactionProductId.getIdProduct());
    }


}
