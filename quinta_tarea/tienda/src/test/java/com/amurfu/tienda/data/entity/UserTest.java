package com.amurfu.tienda.data.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User user;
    private Address address;
    private ShoppingCart shoppingCart;
    private Review review;
    private Transaction transaction;
    private List<Address> addresses;
    private List<Review> reviews;
    private List<Transaction> transactions;


    private Date date;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        user = new User();
        address = new Address();
        shoppingCart = new ShoppingCart();
        review = new Review();
        transaction = new Transaction();
        addresses = new ArrayList<>();
        reviews = new ArrayList<>();
        transactions = new ArrayList<>();
        addresses.add(address);
        reviews.add(review);
        transactions.add(transaction);
        date = new Date();
    }

    @Test
    void testIdUser(){
        assertNull(user.getIdUser());
        user.setIdUser(1);
        assertEquals(1,user.getIdUser());
    }

    @Test
    void testGetFirstName(){
        assertNull(user.getFirstName());
        user.setFirstName("FirstName");
        assertEquals("FirstName",user.getFirstName());
    }

    @Test
    void testMiddleName(){
        assertNull(user.getMiddleName());
        user.setMiddleName("middleName");
        assertEquals("middleName",user.getMiddleName());
    }

    @Test
    void testLastName(){
        assertNull(user.getLastName());
        user.setLastName("lastName");
        assertEquals("lastName",user.getLastName());
    }

    @Test
    void testSecondLastName(){
        assertNull(user.getSecondLastName());
        user.setSecondLastName("secondLastName");
        assertEquals("secondLastName",user.getSecondLastName());
    }
    @Test
    void testEmail(){
        assertNull(user.getEmail());
        user.setEmail("email");
        assertEquals("email",user.getEmail());
    }

    @Test
    void testPassword(){
        assertNull(user.getPassword());
        user.setPassword("password");
        assertEquals("password",user.getPassword());
    }

    @Test
    void testPhone(){
        assertNull(user.getPhone());
        user.setPhone(1L);
        assertEquals(1L,user.getPhone());
    }

    @Test
    void testAvatar(){
        assertNull(user.getAvatar());
        user.setAvatar("avatar");
        assertEquals("avatar",user.getAvatar());
    }

    @Test
    void testCreatedAt() {
        assertNull(user.getCreatedAt());
        user.setCreatedAt(date);
        assertEquals(date,user.getCreatedAt());
    }

    @Test
    void testAddresses() {
        assertNull(user.getAddresses());
        user.setAddresses(addresses);
        assertEquals(addresses,user.getAddresses());
    }

    @Test
    void testShoppingCart() {
        assertNull(user.getShoppingCart());
        user.setShoppingCart(shoppingCart);
        assertEquals(shoppingCart,user.getShoppingCart());
    }

    @Test
    void testReviews(){
        assertNull(user.getReviews());
        user.setReviews(reviews);
        assertEquals(reviews,user.getReviews());
    }

    @Test
    void testTransactions(){
        assertNull(user.getTransactions());
        user.setTransactions(transactions);
        assertEquals(transactions,user.getTransactions());
    }

}
