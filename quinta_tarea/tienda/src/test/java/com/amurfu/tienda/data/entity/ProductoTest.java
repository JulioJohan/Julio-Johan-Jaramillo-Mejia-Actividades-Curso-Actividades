package com.amurfu.tienda.data.entity;


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
public class ProductoTest {

    private Product product;

    private Category category;

    private SubCategory subCategory;

    private ShoppingCart shoppingCart;

    private Review review;

    private List<Review> reviews;

    private Date createdAt;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        createdAt = new Date();
        product = new Product();
        category = new Category();
        subCategory = new SubCategory();
        shoppingCart = new ShoppingCart();
        review = new Review();
        reviews = new ArrayList<>();
        reviews.add(review);
    }

    @Test
    void idProductTest(){
        assertNull(product.getIdProduct());
        product.setIdProduct(1);
        assertEquals(1, product.getIdProduct());
    }

    @Test
    void nameProductTest(){
        assertNull(product.getNameProduct());
        product.setNameProduct("NameProduct");
        assertEquals("NameProduct", product.getNameProduct());
    }

    @Test
    void descriptionTest(){
        assertNull(product.getDescription());
        product.setDescription("Description");
        assertEquals("Description", product.getDescription());
    }

    @Test
    void serialTest(){
        assertNull(product.getSerial());
        product.setSerial("Serial");
        assertEquals("Serial", product.getSerial());
    }

    @Test
    void statusTest(){
        assertNull(product.getStatus());
        product.setStatus("Status");
        assertEquals("Status", product.getStatus());
    }

    @Test
    void stockTest(){
        assertNull(product.getStock());
        product.setStock(1);
        assertEquals(1, product.getStock());
    }

    @Test
    void priceTest(){
        assertNull(product.getPrice());
        product.setPrice(new BigDecimal("1"));
        assertEquals(new BigDecimal("1"), product.getPrice());
    }

    @Test
    void categoryTest(){
        assertNull(product.getCategory());
        product.setCategory(category);
        assertEquals(category, product.getCategory());
    }

    @Test
    void subCategoryTest(){
        assertNull(product.getSubCategory());
        product.setSubCategory(subCategory);
        assertEquals(subCategory, product.getSubCategory());
    }

    @Test
    void shoppingCartTest(){
        assertNull(product.getShoppingCart());
        product.setShoppingCart(shoppingCart);
        assertEquals(shoppingCart, product.getShoppingCart());
    }

    @Test
    void reviewsTest(){
        assertNull(product.getReviews());
        product.setReviews(reviews);
        assertEquals(reviews, product.getReviews());
    }


    @Test
    void createdTest(){
        assertNull(product.getCreatedAt());
        product.setCreatedAt(createdAt);
        assertEquals(createdAt, product.getCreatedAt());
    }

}
