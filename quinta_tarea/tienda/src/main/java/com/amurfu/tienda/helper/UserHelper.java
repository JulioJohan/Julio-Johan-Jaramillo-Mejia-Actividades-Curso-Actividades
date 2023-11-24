package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.UserDTO;
import com.amurfu.tienda.data.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper implements IUserHelper{

    @Autowired
    private ModelMapper modelMapper;


//    Convertir una entidad a un DTO
    @Override
    public UserDTO convertToDtoUser(User user){
        return modelMapper.map(user, UserDTO.class);
    }

}
