package com.amurfu.tienda.data.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@ExtendWith(MockitoExtension.class)
public class AddressDTOTest {
	
	private AddressDTO addressDTO;
	private Validator validator;
	
	@BeforeEach
    @DisplayName("╯°□°）╯")
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        addressDTO = new AddressDTO();        
    }
	
	@Test
	void fullNameTest() {
		assertNull(addressDTO.getFullName());
		addressDTO.setFullName("FullName");
		assertEquals("FullName", addressDTO.getFullName());
	}
	
	@Test
	void idAddressTest() {
		assertNull(addressDTO.getIdAddress());
		addressDTO.setIdAddress(1);
		assertEquals(1, addressDTO.getIdAddress());
	}
	
	@Test
	void phoneTest() {
		assertNull(addressDTO.getPhone());
		addressDTO.setPhone(1L);
		assertEquals(1L, addressDTO.getPhone());
	}
	
	@Test
	void postalCodeTest() {
		assertNull(addressDTO.getPostalCode());
		addressDTO.setPostalCode("12A");
		assertEquals("12A", addressDTO.getPostalCode());
	}
	
	@Test
	void countryTest() {
		assertNull(addressDTO.getCountry());
		addressDTO.setCountry("Country");
		assertEquals("Country", addressDTO.getCountry());
	}
	

	@Test
	void estateTest() {
		assertNull(addressDTO.getEstate());
		addressDTO.setEstate("Estate");
		assertEquals("Estate", addressDTO.getEstate());
	}
	
	@Test
	void cityTest() {
		assertNull(addressDTO.getCity());
		addressDTO.setCity("Estate");
		assertEquals("Estate", addressDTO.getCity());
	}		
	
	@Test
	void streetTest() {
		assertNull(addressDTO.getStreet());
		addressDTO.setStreet("Street");
		assertEquals("Street", addressDTO.getStreet());
	}
	
	@Test
	void outerNumberTest() {
		assertNull(addressDTO.getOuterNumber());
		addressDTO.setOuterNumber("OuterNumber");
		assertEquals("OuterNumber", addressDTO.getOuterNumber());
	}
	
	@Test
	void innerNumberTest() {
		assertNull(addressDTO.getInnerNumber());
		addressDTO.setInnerNumber("InnerNumber");
		assertEquals("InnerNumber", addressDTO.getInnerNumber());
	}
	
	@Test
	void addressReferencesTest() {
		assertNull(addressDTO.getAddressReferences());
		addressDTO.setAddressReferences("AddressReferences");
		assertEquals("AddressReferences", addressDTO.getAddressReferences());
	}
	
	@Test
	void idUserTest() {
		assertNull(addressDTO.getIdUser());
		addressDTO.setIdUser(1);
		assertEquals(1, addressDTO.getIdUser());
	}
	
	@Test
	void testUserDTOTest() {
	AddressDTO addressDTO = new AddressDTO();	    	
	Set<ConstraintViolation<AddressDTO>> violations = validator.validate(addressDTO);	      
	assertEquals(18, violations.size());
	}
	
	
	
}
