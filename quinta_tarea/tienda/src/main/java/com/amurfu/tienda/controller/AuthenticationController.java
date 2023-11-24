package com.amurfu.tienda.controller;

import com.amurfu.tienda.data.dto.CredentialsDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.service.AuthenticationService;
import com.amurfu.tienda.service.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticacion")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    // Inyección automática de la dependencia JwtService.
    @Autowired
    private final JWTService jwtService;

    // Constructor para inyectar JwtService.
    public AuthenticationController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<String>> login(@Valid @RequestBody CredentialsDTO credentialsDTO){
        Response<String> response = authenticationService.login(credentialsDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
