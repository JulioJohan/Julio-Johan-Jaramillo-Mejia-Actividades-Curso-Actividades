package com.amurfu.tienda.controller;


import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.UserDTO;
import com.amurfu.tienda.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"enctype", "Authorization"})
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping(value = "/save_user",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<UserDTO>> saveUser(@Valid @RequestBody UserDTO userDto){
        Response<UserDTO> userDTO = userService.saveUser(userDto);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/get_user",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<UserDTO>> getUser(){
        Response<UserDTO> userDTO = userService.getAllUser();
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/get_user/{idUser}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<UserDTO>> getUserById(@PathVariable("idUser") Integer idUser ){
        Response<UserDTO> response = userService.getUserById(idUser);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
