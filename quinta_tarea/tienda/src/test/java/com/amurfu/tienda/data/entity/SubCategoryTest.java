package com.amurfu.tienda.data.entity;


import com.amurfu.tienda.data.dto.AddressDTO;
import com.amurfu.tienda.data.dto.SubCategoryDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class SubCategoryTest {
    
    private SubCategory subCategory;
    private Category category;

    private Product product;

    private List<Product> products;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        subCategory = new SubCategory();
        category = new Category();
        product = new Product();
        products = new ArrayList<>();
        products.add(product);
    }


    @Test
    void idSubCategoryTest(){
        assertNull(subCategory.getIdSubCategory());
        subCategory.setIdSubCategory(1);
        assertEquals(1,subCategory.getIdSubCategory());
    }

    @Test
    void nameSubCategoryTest(){
        assertNull(subCategory.getNameSubCategory());
        subCategory.setNameSubCategory("NameSubCategory");
        assertEquals("NameSubCategory",subCategory.getNameSubCategory());
    }

    @Test
    void idCategoryTest(){
        assertNull(subCategory.getCategory());
        subCategory.setCategory(category);
        assertEquals(category,subCategory.getCategory());
    }

    @Test
    void productsTest(){
        assertNull(subCategory.getProducts());
        subCategory.setProducts(products);
        assertEquals(products,subCategory.getProducts());
    }

}
