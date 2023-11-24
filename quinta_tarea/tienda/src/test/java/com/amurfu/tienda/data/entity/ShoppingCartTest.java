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
public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    private User user;

    private Product product;

    private List<Product> products;

    private Date date;



    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        shoppingCart = new ShoppingCart();
        product = new Product();
        user = new User();
        date = new Date();
        products = new ArrayList<>();
        products.add(product);
    }

    @Test
    void idShoppingCartTest(){
        assertNull(shoppingCart.getIdShoppingCart());
        shoppingCart.setIdShoppingCart(1);
        assertEquals(1, shoppingCart.getIdShoppingCart());
    }

    @Test
    void subtotalTest(){
        shoppingCart.setSubtotal(new BigDecimal("1"));
        assertEquals(new BigDecimal("1"), shoppingCart.getSubtotal());
    }

    @Test
    void userTest(){
        assertNull(shoppingCart.getUser());
        shoppingCart.setUser(user);
        assertEquals(user, shoppingCart.getUser());
    }

    @Test
    void productsTest(){
        assertNull(shoppingCart.getProducts());
        shoppingCart.setProducts(products);
        assertEquals(products, shoppingCart.getProducts());
    }

    @Test
    void dateTest(){
        assertNull(shoppingCart.getCreatedAt());
        shoppingCart.setCreatedAt(date);
        assertEquals(date, shoppingCart.getCreatedAt());
    }

}
