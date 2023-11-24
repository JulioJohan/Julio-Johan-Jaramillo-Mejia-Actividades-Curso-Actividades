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
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class ProductDTOTest {

    private ProductDTO productDTO;

    private Validator validator;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        productDTO = new ProductDTO();
    }

    @Test
    void idProductTest(){
        assertNull(productDTO.getIdProduct());
        productDTO.setIdProduct(1);
        assertEquals(1, productDTO.getIdProduct());
    }

    @Test
    void nameProductTest(){
        assertNull(productDTO.getNameProduct());
        productDTO.setNameProduct("NameProduct");
        assertEquals("NameProduct", productDTO.getNameProduct());
    }

    @Test
    void descriptionTest(){
        assertNull(productDTO.getDescription());
        productDTO.setDescription("Description");
        assertEquals("Description", productDTO.getDescription());
    }

    @Test
    void serialTest(){
        assertNull(productDTO.getSerial());
        productDTO.setSerial("Serial");
        assertEquals("Serial", productDTO.getSerial());
    }

    @Test
    void statusTest(){
        assertNull(productDTO.getStatus());
        productDTO.setStatus("Status");
        assertEquals("Status", productDTO.getStatus());
    }

    @Test
    void stockTest(){
        assertNull(productDTO.getStock());
        productDTO.setStock(1);
        assertEquals(1, productDTO.getStock());
    }

    @Test
    void priceTest(){
        assertNull(productDTO.getPrice());
        productDTO.setPrice(new BigDecimal("1"));
        assertEquals(new BigDecimal("1"), productDTO.getPrice());
    }

    @Test
    void idCategoryTest(){
        assertNull(productDTO.getIdCategory());
        productDTO.setIdCategory(1);
        assertEquals(1, productDTO.getIdCategory());
    }

    @Test
    void idSubCategoryTest(){
        assertNull(productDTO.getIdSubCategory());
        productDTO.setIdSubCategory(1);
        assertEquals(1, productDTO.getIdSubCategory());
    }

    @Test
    void testProductDTOTest() {
        ProductDTO productDTO = new ProductDTO();
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertEquals(12, violations.size());
    }

}
