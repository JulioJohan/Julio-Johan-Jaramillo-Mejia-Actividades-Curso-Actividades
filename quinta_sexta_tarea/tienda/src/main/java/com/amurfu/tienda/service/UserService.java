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

    @Override
    public Response<UserDTO> saveUser(@Valid UserDTO userDTO){
        Response<UserDTO> response = new Response<>();
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setLastName(userDTO.getLastName());
        user.setSecondLastName(userDTO.getSecondLastName());

        Optional<User> userEmail = userRepository.findByEmail(userDTO.getEmail());
        if(userEmail.isPresent()){
            throw new BusinessException(HttpStatus.BAD_REQUEST, Constants.EXISTS_USER);
        }

        Optional<User> userPhone = userRepository.findByPhone(userDTO.getPhone());

        if(userPhone.isPresent() ){
            throw new BusinessException(HttpStatus.BAD_REQUEST,Constants.EXISTS_USER_TELEPHONE);
        }
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setAvatar(userDTO.getAvatar());
        user = userRepository.save(user);
        userDTO.setIdUser(user.getIdUser());
        response.setData(userDTO);
        response.setMessage("El usuario se creo correctamente");
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
        response.setList(userList);
        response.setMessage("Se consultaron todos los usuarios correctamente");
        return response;
    }
}
