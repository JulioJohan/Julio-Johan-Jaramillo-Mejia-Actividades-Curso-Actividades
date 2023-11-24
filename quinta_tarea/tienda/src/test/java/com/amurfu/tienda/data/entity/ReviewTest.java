package com.amurfu.tienda.data.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class ReviewTest {

    private Review review;
    private User user;

    private Product product;



    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        review = new Review();
        user = new User();
        product = new Product();
    }

    @Test
    void idReviewTest(){
        assertNull(review.getIdReview());
        review.setIdReview(1);
        assertEquals(1, review.getIdReview());
    }


    @Test
    void descriptionTest(){
        assertNull(review.getDescription());
        review.setDescription("Description");
        assertEquals("Description", review.getDescription());
    }

    @Test
    void imgTest(){
        assertNull(review.getImg());
        review.setImg("img");
        assertEquals("img", review.getImg());
    }

    @Test
    void userTest(){
        assertNull(review.getUser());
        review.setUser(user);
        assertEquals(user, review.getUser());
    }

    @Test
    void productTest(){
        assertNull(review.getProduct());
        review.setProduct(product);
        assertEquals(product, review.getProduct());
    }



}
