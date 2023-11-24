package com.amurfu.tienda.data.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class CommentTest {

    private Comment comment;
    private Product product;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        comment = new Comment();
        product = new Product();
    }

    @Test
    void idCommentTest() {
        assertNull(comment.getIdComment());
        comment.setIdComment(1);
        assertEquals(1, comment.getIdComment());
    }

    @Test
    void descriptionTest() {
        assertNull(comment.getDescription());
        comment.setDescription("Description");
        assertEquals("Description", comment.getDescription());
    }

    @Test
    void imgTest() {
        assertNull(comment.getImg());
        comment.setImg("Imagen");
        assertEquals("Imagen", comment.getImg());
    }

    @Test
    void productTest() {
        assertNull(comment.getProduct());
        comment.setProduct(product);
        assertEquals(product, comment.getProduct());
    }


}
