package com.amurfu.tienda.controller;


import com.amurfu.tienda.data.dto.AddressDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Address;
import com.amurfu.tienda.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @PostMapping(value = "/add_address_user",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<AddressDTO>> addAdressUser(@Valid @RequestBody AddressDTO addressDTO){
        Response<AddressDTO> response = addressService.addAddressUser(addressDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/get_address_user/{idUser}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Response<AddressDTO>> getAddressByUser(@PathVariable("idUser") Integer idUser){
        Response<AddressDTO> response = addressService.getAddressByUser(idUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
