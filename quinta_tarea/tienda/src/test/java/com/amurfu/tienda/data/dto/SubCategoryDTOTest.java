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

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class SubCategoryDTOTest {

    private SubCategoryDTO subCategoryDTO;
    private Validator validator;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        subCategoryDTO = new SubCategoryDTO();
    }

    @Test
    void idSubCategoryTest(){
        assertNull(subCategoryDTO.getIdSubCategory());
        subCategoryDTO.setIdSubCategory(1);
        assertEquals(1,subCategoryDTO.getIdSubCategory());
    }

    @Test
    void nameSubCategoryTest(){
        assertNull(subCategoryDTO.getNameSubCategory());
        subCategoryDTO.setNameSubCategory("NameSubCategory");
        assertEquals("NameSubCategory",subCategoryDTO.getNameSubCategory());
    }

    @Test
    void idCategoryTest(){
        assertNull(subCategoryDTO.getIdCategory());
        subCategoryDTO.setIdCategory(1);
        assertEquals(1,subCategoryDTO.getIdCategory());
    }

    @Test
    void testSubCategoryDTOTest() {
        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
        Set<ConstraintViolation<SubCategoryDTO>> violations = validator.validate(subCategoryDTO);
        assertEquals(3, violations.size());
    }
}
