package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.CredentialsDTO;
import com.amurfu.tienda.data.dto.Response;

public interface IAuthenticationService {

    Response<String> login (CredentialsDTO credentialsDTO);

}
