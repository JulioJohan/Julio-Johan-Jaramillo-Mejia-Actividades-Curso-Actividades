package com.amurfu.tienda.controller;


import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.TransactionDTO;
import com.amurfu.tienda.data.dto.UserDTO;
import com.amurfu.tienda.service.ITransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"enctype", "Authorization"})
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    ITransactionService transactionService;

    @PostMapping(value = "/generate_purchase",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<TransactionDTO>> generatePurchase (@Valid @RequestBody TransactionDTO transactionDTO){
        Response<TransactionDTO> response = transactionService.generatePurchase(transactionDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
