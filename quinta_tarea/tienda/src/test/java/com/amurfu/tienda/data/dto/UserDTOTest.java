package com.amurfu.tienda.data.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class UserDTOTest {

    private UserDTO userDTO;
    private Validator validator;


   
    @BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        userDTO = new UserDTO();        
    }

    @Test
    void testIdUser(){
        assertNull(userDTO.getIdUser());
        userDTO.setIdUser(1);
        assertEquals(1,userDTO.getIdUser());
    }

    @Test
    void testGetFirstName(){
        assertNull(userDTO.getFirstName());
        userDTO.setFirstName("FirstName");
        assertEquals("FirstName",userDTO.getFirstName());
    }

    @Test
    void testMiddleName(){
        assertNull(userDTO.getMiddleName());
        userDTO.setMiddleName("middleName");
        assertEquals("middleName",userDTO.getMiddleName());
    }

    @Test
    void testLastName(){
        assertNull(userDTO.getLastName());
        userDTO.setLastName("lastName");
        assertEquals("lastName",userDTO.getLastName());
    }

    @Test
    void testSecondLastName(){
        assertNull(userDTO.getSecondLastName());
        userDTO.setSecondLastName("secondLastName");
        assertEquals("secondLastName",userDTO.getSecondLastName());
    }
    @Test
    void testEmail(){
        assertNull(userDTO.getEmail());
        userDTO.setEmail("email");
        assertEquals("email",userDTO.getEmail());
    }

    @Test
    void testPassword(){
        assertNull(userDTO.getPassword());
        userDTO.setPassword("password");
        assertEquals("password",userDTO.getPassword());
    }

    @Test
    void testPhone(){
        assertNull(userDTO.getPhone());
        userDTO.setPhone(1L);
        assertEquals(1L,userDTO.getPhone());
    }

    @Test
    void testAvatar(){
        assertNull(userDTO.getAvatar());
        userDTO.setAvatar("avatar");
        assertEquals("avatar",userDTO.getAvatar());
    }
    
    @Test
    void testInvalidUserDTO() {
        assertNull(userDTO.getFirstName());
    	userDTO.setFirstName("firstName");
        assertEquals("firstName",userDTO.getFirstName());
    }
    
    @Test
    void testUserDTOTest() {
    	UserDTO userDTO = new UserDTO();
    	
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
       
        assertEquals(9, violations.size());

    }

}
