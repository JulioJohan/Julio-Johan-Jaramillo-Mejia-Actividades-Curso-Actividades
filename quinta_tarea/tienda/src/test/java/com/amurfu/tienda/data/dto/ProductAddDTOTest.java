package com.amurfu.tienda.data.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ProductAddDTOTest {

    private ProductAddDTO productAddDTO;

    private Validator validator;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        productAddDTO = new ProductAddDTO();
    }

    @Test
    void idProductTest(){
        productAddDTO.setIdProduct(1);
        assertEquals(1,productAddDTO.getIdProduct());
    }

    @Test
    void quantityProductsTest(){
        productAddDTO.setQuantityProducts(1);
        assertEquals(1,productAddDTO.getQuantityProducts());
    }

    @Test
    void priceTest(){
        productAddDTO.setPrice(new BigDecimal("1"));
        assertEquals(new BigDecimal("1"),productAddDTO.getPrice());
    }

    @Test
    void totalTest(){
        productAddDTO.setTotal(new BigDecimal("1"));
        assertEquals(new BigDecimal("1"),productAddDTO.getTotal());
    }

    @Test
    void testProductAddTest(){
        ProductAddDTO productAddDTO = new ProductAddDTO();
        Set<ConstraintViolation<ProductAddDTO>> violations = validator.validate(productAddDTO);
        assertEquals(3,violations.size());

    }
}
