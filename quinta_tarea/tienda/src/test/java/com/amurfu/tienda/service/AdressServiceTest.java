package com.amurfu.tienda.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amurfu.tienda.data.dto.AddressDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Address;
import com.amurfu.tienda.data.entity.User;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.IAddressHelper;
import com.amurfu.tienda.repository.IAddressRepository;
import com.amurfu.tienda.repository.IUserRepository;

@ExtendWith(MockitoExtension.class)
public class AdressServiceTest {

    @InjectMocks
    AddressService addressService;
    
    @Mock
    IUserRepository userRepository;
    
    @Mock
    IAddressRepository addressRepository;
    
    @Mock
    IAddressHelper addressHelper;

    
    List<Address> listAddress;
    
    AddressDTO addressDTO;
    Address address;
    
    Integer idAddress;
    Integer idUser;
    
	Optional<User> userOptional;
	Optional<Address> addressOptional;


    @BeforeEach
    @DisplayName("╯°□°）╯ Address")
    void setUp() {
    	userOptional = Optional.of(new User());
    	addressOptional = Optional.of(new Address());
    	addressDTO = new AddressDTO();
    	addressDTO.setAddressReferences("AddressReferences");
    	addressDTO.setCity("City");
    	addressDTO.setCountry("Country");
    	addressDTO.setEstate("Estate");
    	addressDTO.setFullName("FullName");
    	addressDTO.setIdAddress(1);
    	addressDTO.setIdUser(1);
    	addressDTO.setInnerNumber("1A");
    	addressDTO.setOuterNumber("OuterNumber");
    	addressDTO.setPhone(41L);
    	addressDTO.setPostalCode("3190");
    	addressDTO.setStreet("Street");
    	
    	address = new Address();
    	address.setIdAddress(1);
    	idAddress = 1;
    	
    	listAddress = new ArrayList<Address>();
    	listAddress.add(address);
    }
    
    @Test
    private void addressUserTest() {
    	when(userRepository.findById(idUser)).thenReturn(userOptional); 	    	    	
    	when(addressRepository.findById(idAddress)).thenReturn(addressOptional);    	
    }
    
    @Test
    private void userTest() {
    	when(userRepository.findById(idUser)).thenReturn(userOptional); 	    	    	
    }
                 
         
    @Test
    void addAddressUserTest(){    	
    	when(userRepository.findById(addressDTO.getIdUser())).thenReturn(userOptional);    	
    	when(addressRepository.save(Mockito.any())).thenReturn(new Address());
    	Response<AddressDTO> response = addressService.addAddressUser(addressDTO);
    	assertNotNull(response);    	
    }
    
    @Test
    void addAddressUserNullTest(){    	
    	when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty()); 	    	
    	assertThrows(BusinessException.class,()->{
    		addressService.addAddressUser(addressDTO);
    	});
    }
    
    @Test
    void updateAddressUserTest() {
    	when(userRepository.findById(addressDTO.getIdUser())).thenReturn(userOptional); 	    	
    	when(addressRepository.findById(idAddress)).thenReturn(addressOptional); 	    	
    	Response<AddressDTO> response = addressService.updateAddressUser(addressDTO,idAddress);
    	assertNotNull(response);
    }
    
    @Test
    void updateAddressNullUserTest() {
    	when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty()); 	    	
    	assertThrows(BusinessException.class,()->{
    		addressService.updateAddressUser(addressDTO,idAddress);
    	});    	
    }
    
    @Test
    void updateAddressNullAddressTest() {
    	when(userRepository.findById(addressDTO.getIdUser())).thenReturn(userOptional); 	    	
    	when(addressRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty()); 	    	
    	assertThrows(BusinessException.class,()->{
    		addressService.updateAddressUser(addressDTO,idAddress);
    	});    	
    }
    
    @Test
    void getAddressByUserListTest() {
    	userTest();
    	when(addressRepository.findByUserIdUser(idUser)).thenReturn(listAddress);
    	Response<AddressDTO> response = addressService.getAddressByUser(idUser);
    	assertNotNull(response);
    }
    
    @Test
    void getAddressByUserListEmptyTest() {
    	userTest();
    	Response<AddressDTO> response = addressService.getAddressByUser(idUser);
    	assertNotNull(response);
    }
    
    @Test
    void getAddressByUserNullTest() {
    	when(userRepository.findById(idUser)).thenReturn(Optional.empty()); 	
    	assertThrows(BusinessException.class,()->{
    		addressService.getAddressByUser(idUser);
    	}); 
    }
    
    @Test
    void deleteAddressByUserTest() {
    	addressUserTest();
    	when(addressRepository.findByUserIdUser(idUser)).thenReturn(listAddress);
    	Response<AddressDTO> response = addressService.deleteAddressByUser(idUser,idAddress);
    	assertNotNull(response);    	
    }
    
    @Test
    void deleteAddressByUserListEmptyTest() {
    	addressUserTest();
    	Response<AddressDTO> response = addressService.deleteAddressByUser(idUser,idAddress);
    	assertNotNull(response);
    }
        
    @Test
    void deleteAddressUserEmptyTest() {
        when(userRepository.findById(idUser)).thenReturn(Optional.empty());
    	assertThrows(BusinessException.class,()->{
    		addressService.deleteAddressByUser(idUser, idAddress);
    	});    
    }
    
    @Test
    void deleteUserUserEmptyTest() {
        when(userRepository.findById(idUser)).thenReturn(Optional.empty());
    	assertThrows(BusinessException.class,()->{
    		addressService.deleteAddressByUser(idUser, idAddress);
    	});    
    }
    
    @Test
    void deleteUserAdressEmptyTest() {
    	userTest();
        when(addressRepository.findById(idAddress)).thenReturn(Optional.empty());
    	assertThrows(BusinessException.class,()->{
    		addressService.deleteAddressByUser(idUser, idAddress);
    	});   
    }
               
                         
}
