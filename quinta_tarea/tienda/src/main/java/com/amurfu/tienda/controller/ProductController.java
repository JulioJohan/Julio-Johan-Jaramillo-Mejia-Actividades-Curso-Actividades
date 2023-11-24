package com.amurfu.tienda.controller;


import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping(value = "/save_product",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<ProductDTO>> saveProduct(@Valid @RequestBody ProductDTO productDTO){
        Response<ProductDTO> response = productService.saveProduct(productDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/get_all_product",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<ProductDTO>> getAllProducts(){
        Response<ProductDTO> response = productService.getAllProduct();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/get_product_id/{idProduct}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<ProductDTO>> getByIdProduct(@PathVariable(name = "idProduct",required = true) Integer idProduct){
        Response<ProductDTO> response = productService.getProductById(idProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete_product_id/{idProduct}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<ProductDTO>> deleteProductById(@PathVariable(name = "idProduct",required = true) Integer idProduct){
        Response<ProductDTO> response = productService.deleteProductById(idProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
