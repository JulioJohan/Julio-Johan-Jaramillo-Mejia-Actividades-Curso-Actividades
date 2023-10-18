package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.UserDTO;

import java.util.List;

public interface IUserService {

    Response<UserDTO> saveUser(UserDTO userDTO);

    Response<UserDTO> getAllUser();
}
