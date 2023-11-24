package com.amurfu.tienda.data.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import jakarta.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class CategoryDTOTest {

    private CategoryDTO categoryDTO;
    private Validator validator;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        categoryDTO = new CategoryDTO();
    }

    @Test
    void idCategoryTest() {
        assertNull(categoryDTO.getIdCategory());
        categoryDTO.setIdCategory(1);
        assertEquals(1, categoryDTO.getIdCategory());
    }

    @Test
    void nameCategoryTest(){
        assertNull(categoryDTO.getNameCategory());
        categoryDTO.setNameCategory("NameCategory");
        assertEquals("NameCategory",categoryDTO.getNameCategory());
    }

    @Test
    void testCategoryTest() {
        CategoryDTO categoryDTO = new CategoryDTO();
        Set<ConstraintViolation<CategoryDTO>> violations = validator.validate(categoryDTO);
        assertEquals(2, violations.size());
    }
		
}
