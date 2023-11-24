package com.amurfu.tienda.service;


import com.amurfu.tienda.data.dto.CredentialsDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.User;
import com.amurfu.tienda.exceptions.EntityNotFoundException;
import com.amurfu.tienda.repository.IUserRepository;
import com.amurfu.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Override
    public Response<String> login(CredentialsDTO credentialsDTO) {
        Response<String> response = new Response<>();

        User userEmail = userRepository.findByEmail(credentialsDTO.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(Constants.USER_NOT_FOUND));

        boolean passwordEquals = passwordEncoder.matches(credentialsDTO.getPassword(),userEmail.getPassword());


        if(!passwordEquals){
            response.setMessage(Constants.USER_PASSWORD_INCORRECT);
        }
        String token = jwtService.generateToken(credentialsDTO.getEmail());
        response.setStatus(Constants.MENSAJE_TOKEN_EXITO);
        response.setData(token);

        return response;
    }
}
