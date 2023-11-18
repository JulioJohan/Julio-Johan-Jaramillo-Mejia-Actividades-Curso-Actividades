package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.UserDTO;
import com.amurfu.tienda.data.entity.User;

public interface IUserHelper {
    UserDTO convertToDtoUser(User user);
}
