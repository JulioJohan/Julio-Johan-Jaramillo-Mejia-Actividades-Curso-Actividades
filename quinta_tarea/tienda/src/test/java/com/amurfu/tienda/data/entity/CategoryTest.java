package com.amurfu.tienda.data.entity;


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
public class CategoryTest {

    private List<SubCategory> subCategories;

    private List<Product> products;

    private Category category;

    private SubCategory subCategory;

    private Product product;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        subCategory = new SubCategory();
        product = new Product();
        category = new Category();

        subCategories = new ArrayList<>();
        products = new ArrayList<>();

        subCategories.add(subCategory);
        products.add(product);

    }

    @Test
    void idCategoryTest() {
        assertNull(category.getIdCategory());
        category.setIdCategory(1);
        assertEquals(1, category.getIdCategory());
    }

    @Test
    void nameCategoryTest(){
        assertNull(category.getNameCategory());
        category.setNameCategory("NameCategory");
        assertEquals("NameCategory",category.getNameCategory());
    }

    @Test
    void subCategoriesTest(){
        category.setSubCategories(subCategories);
        assertEquals(subCategories,category.getSubCategories());
    }

    @Test
    void productTest(){
        category.setProduct(products);
        assertEquals(products,category.getProduct());
    }
}
