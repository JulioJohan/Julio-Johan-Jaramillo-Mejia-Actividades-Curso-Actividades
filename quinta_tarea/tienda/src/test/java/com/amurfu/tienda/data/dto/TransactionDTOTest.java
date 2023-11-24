package com.amurfu.tienda.data.dto;


import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TransactionDTOTest {

    private TransactionDTO transactionDTO;
    private Validator validator;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        transactionDTO = new TransactionDTO();
    }

    @Test
    void idTransactionTest(){
        assertNull(transactionDTO.getIdTransaction());
        transactionDTO.setIdTransaction(1);
        assertEquals(1, transactionDTO.getIdTransaction());
    }

    @Test
    void idUserTest(){
        assertNull(transactionDTO.getIdUser());
        transactionDTO.setIdUser(1);
        assertEquals(1, transactionDTO.getIdUser());
    }

    @Test
    void idFormPaymentTest(){
        assertNull(transactionDTO.getIdFormPayment());
        transactionDTO.setIdFormPayment(1);
        assertEquals(1, transactionDTO.getIdFormPayment());
    }

    @Test
    void idTotalTest(){
        assertNull(transactionDTO.getTotal());
        transactionDTO.setTotal(new BigDecimal("1"));
        assertEquals(new BigDecimal("1"), transactionDTO.getTotal());
    }

    @Test
    void dateTest(){
        assertNull(transactionDTO.getDate());
        transactionDTO.setDate(new Date());
        assertEquals(new Date(), transactionDTO.getDate());
    }





}
