package com.amurfu.tienda.data.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class AddressTest {
    
    private Address address;
    private User user;

    private Date date;

    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        date = new Date();
        user = new User();
        address = new Address();
    }

    @Test
    void fullNameTest() {
        assertNull(address.getFullName());
        address.setFullName("FullName");
        assertEquals("FullName", address.getFullName());
    }

    @Test
    void idAddressTest() {
        assertNull(address.getIdAddress());
        address.setIdAddress(1);
        assertEquals(1, address.getIdAddress());
    }

    @Test
    void phoneTest() {
        assertNull(address.getPhone());
        address.setPhone(1L);
        assertEquals(1L, address.getPhone());
    }

    @Test
    void postalCodeTest() {
        assertNull(address.getPostalCode());
        address.setPostalCode("12A");
        assertEquals("12A", address.getPostalCode());
    }

    @Test
    void countryTest() {
        assertNull(address.getCountry());
        address.setCountry("Country");
        assertEquals("Country", address.getCountry());
    }


    @Test
    void estateTest() {
        assertNull(address.getEstate());
        address.setEstate("Estate");
        assertEquals("Estate", address.getEstate());
    }

    @Test
    void cityTest() {
        assertNull(address.getCity());
        address.setCity("Estate");
        assertEquals("Estate", address.getCity());
    }

    @Test
    void streetTest() {
        assertNull(address.getStreet());
        address.setStreet("Street");
        assertEquals("Street", address.getStreet());
    }

    @Test
    void outerNumberTest() {
        assertNull(address.getOuterNumber());
        address.setOuterNumber("OuterNumber");
        assertEquals("OuterNumber", address.getOuterNumber());
    }

    @Test
    void innerNumberTest() {
        assertNull(address.getInnerNumber());
        address.setInnerNumber("InnerNumber");
        assertEquals("InnerNumber", address.getInnerNumber());
    }

    @Test
    void addressReferencesTest() {
        assertNull(address.getAddressReferences());
        address.setAddressReferences("AddressReferences");
        assertEquals("AddressReferences", address.getAddressReferences());
    }

    @Test
    void createdAtTest() {
        assertNull(address.getCreatedAt());
        address.setCreatedAt(date);
        assertEquals(date, address.getCreatedAt());
    }

    @Test
    void userTest() {
        assertNull(address.getUser());
        address.setUser(user);
        assertEquals(user, address.getUser());
    }

}
