package com.amurfu.tienda.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.SubCategoryDTO;
import com.amurfu.tienda.data.dto.UserDTO;
import com.amurfu.tienda.data.entity.User;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.IUserHelper;
import com.amurfu.tienda.repository.IUserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	IUserRepository userRepository;
	
	@Mock
    IUserHelper userHelper;
	
	@Mock
    PasswordEncoder passwordEncoder;




	String email;
	Integer idUser;
	
	Optional<User> userEmail; 
	Optional<User> userOptional; 

	UserDTO userDTO;
	User user;
	User userNew;
	
	List<User> listUser;
	
	
	@BeforeEach
	void setUp() {
		idUser = 1; 
		email = "Email";
		
		user = new User();
		userNew = new User();
		user.setIdUser(1);
		
		userDTO = new UserDTO();
		userDTO.setIdUser(1);
		userDTO.setFirstName("FirstName");
		userDTO.setMiddleName("MiddleName");
		userDTO.setLastName("LastName");
		userDTO.setSecondLastName("SecondLastName");		
		userDTO.setEmail("Email");
		userDTO.setPassword("Password");
		userDTO.setPhone(418L);
		userDTO.setAvatar("Avatar");		
		userEmail = Optional.of(user);
		
		userNew.setEmail("email");
		userNew.setPhone(11L);
		userNew.setPassword("password");
		userOptional = Optional.of(userNew);
		
		listUser = new ArrayList<User>();
		listUser.add(user);
		
		
	}
	
	@Test
	void saveUserEmailExistTest() {
		when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(userEmail);
		assertThrows(BusinessException.class, ()->{
			userService.saveUser(userDTO);
		});
	}
	@Test
	void saveUserPhoneExistTest() {
		when(userRepository.findByPhone(userDTO.getPhone())).thenReturn(userEmail);
		assertThrows(BusinessException.class, ()->{
			userService.saveUser(userDTO);
		});
	}
	
	
	@Test
	void saveUserTest() {		
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
		when(userRepository.findByPhone(Mockito.anyLong())).thenReturn(Optional.empty());

		when(userRepository.save(Mockito.any())).thenReturn(user);
		Response<UserDTO> response = userService.saveUser(userDTO);
		assertNotNull(response);				
	}
	

	@Test
	void updateUserTest() {		
		when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(userEmail);
		when(userRepository.save(Mockito.any())).thenReturn(user);
		when(userHelper.convertToDtoUser(Mockito.any())).thenReturn(userDTO);
		Response<UserDTO> response = userService.updateUser(userDTO,idUser);
		assertNotNull(response);				
	}
	
	@Test
	void getAllUserTest() {
		when(userRepository.findAll()).thenReturn(listUser);
		Response<UserDTO> response = userService.getAllUser();
		assertNotNull(response);						
	}
	
	@Test
	void getAllUserEmptyTest() {		
		when(userRepository.findAll()).thenReturn(new ArrayList<>());
		assertThrows(BusinessException.class, ()->{
			userService.getAllUser();
		});					
	}
	
	@Test
	void getUserByIdTest() {
		when(userRepository.findById(idUser)).thenReturn(userEmail);
		Response<UserDTO> response = userService.getUserById(idUser);
		assertNotNull(response);
	}
	
	@Test
	void getUserByIdEmptyTest() {
		when(userRepository.findById(idUser)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, ()->{
			userService.getUserById(idUser);
		});	
				
	}
	
	
	
}
