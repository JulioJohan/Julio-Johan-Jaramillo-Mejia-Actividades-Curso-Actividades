package com.amurfu.tienda.data.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class ProfileMakerTest {

    private ProfileMaker profileMaker;

    private User user;
    private Date date;

    @BeforeEach
    void setUp(){
        profileMaker = new ProfileMaker();
        user = new User();
        date = new Date();
    }

    @Test
    void idProfileMarkerTest(){
        assertNull(profileMaker.getIdProfileMarker());
        profileMaker.setIdProfileMarker(1);
        assertEquals(1,profileMaker.getIdProfileMarker());
    }

    @Test
    void nameProfileTest(){
        assertNull(profileMaker.getNameProfile());
        profileMaker.setNameProfile("NameProfile");
        assertEquals("NameProfile",profileMaker.getNameProfile());
    }

    @Test
    void descriptionTest(){
        assertNull(profileMaker.getDescription());
        profileMaker.setDescription("Description");
        assertEquals("Description",profileMaker.getDescription());
    }

    @Test
    void createdAtTest(){
        assertNull(profileMaker.getCreatedAt());
        profileMaker.setCreatedAt(date);
        assertEquals(date,profileMaker.getCreatedAt());
    }

    @Test
    void userTest(){
        assertNull(profileMaker.getUser());
        profileMaker.setUser(user);
        assertEquals(user,profileMaker.getUser());
    }

}
