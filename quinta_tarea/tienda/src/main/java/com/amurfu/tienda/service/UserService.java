package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.UserDTO;
import com.amurfu.tienda.data.entity.User;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.IUserHelper;
import com.amurfu.tienda.repository.IUserRepository;
import com.amurfu.tienda.util.Constants;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserHelper userHelper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Response<UserDTO> saveUser(@Valid UserDTO userDTO){    
        Response<UserDTO> response = new Response<>();
        User user = new User();
        
        Optional<User> userEmail = userRepository.findByEmail(userDTO.getEmail());
        if(userEmail.isPresent()){
            throw new BusinessException(HttpStatus.BAD_REQUEST, Constants.EXISTS_USER);
        }

        Optional<User> userPhone = userRepository.findByPhone(userDTO.getPhone());

        if(userPhone.isPresent() ){
            throw new BusinessException(HttpStatus.BAD_REQUEST,Constants.EXISTS_USER_TELEPHONE);
        }
        
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setLastName(userDTO.getLastName());
        user.setSecondLastName(userDTO.getSecondLastName());      
        user.setEmail(userDTO.getEmail());
//        codifica la contrasenia
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setPhone(userDTO.getPhone());
        user.setAvatar(userDTO.getAvatar());
        user = userRepository.save(user);
        userDTO.setIdUser(user.getIdUser());
        response.setData(userDTO);
        response.setMessage("El usuario se creo correctamente");
        return response;
    }

    @Override
    public Response<UserDTO> updateUser(UserDTO userDTO, Integer idUser) {
        Response<UserDTO> response = new Response<>();
        Optional<User> userEmail = userRepository.findByEmail(userDTO.getEmail());
        if(userEmail.isEmpty()){
            throw new BusinessException(HttpStatus.BAD_REQUEST, Constants.USER_NOT_FOUND);
        }
        User user = userEmail.get();
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setSecondLastName(userDTO.getSecondLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAvatar(userDTO.getAvatar());
        userRepository.save(user);

        userDTO = userHelper.convertToDtoUser(user);
        response.setData(userDTO);
        response.setMessage("Se actualizó la información correctamente");
        return response;
    }

    @Override
    public Response<UserDTO> getAllUser() {
        Response<UserDTO> response = new Response<>();
        List<UserDTO> userList = new ArrayList<>();
        for(User user:userRepository.findAll()){
            UserDTO userDTO = userHelper.convertToDtoUser(user);
            userList.add(userDTO);
        }
        if (userList.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.USERS_NOT_FOUND);
        }
        response.setList(userList);
        response.setMessage("Se consultaron todos los usuarios correctamente");
        return response;
    }
    @Override
    public Response<UserDTO> getUserById(Integer idUser){
        Response<UserDTO> response = new Response<>();
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,"El usuario no existe");
        }
        UserDTO userDTO = userHelper.convertToDtoUser(user.get());
        response.setData(userDTO);
        response.setMessage("La consulta por usuario se hizo correctamente");
        return response;

    }

}
