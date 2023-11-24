package com.amurfu.tienda.controller;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.SubCategoryDTO;
import com.amurfu.tienda.service.ISubCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("sub_category")
public class SubCategoryController {

    @Autowired
    private ISubCategoryService subCategoryService;

    @GetMapping(value = "/get_all_sub_categories",produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Response<SubCategoryDTO>> getAddressByUser(){
        Response<SubCategoryDTO> response = subCategoryService.getAllSubCategory();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/save_sub_category",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<SubCategoryDTO>> saveSubCategory(@Valid @RequestBody SubCategoryDTO subCategoryDTO){
        Response<SubCategoryDTO> response = subCategoryService.saveSubCategory(subCategoryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/get_sub_category_id/{idSubCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Response<SubCategoryDTO>> getAddressByUser(@PathVariable("idSubCategory") Integer idSubCategory){
        Response<SubCategoryDTO> response = subCategoryService.getSubCategoryById(idSubCategory);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/update_sub_category/{idSubCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Response<SubCategoryDTO>> updateAddressUser(@Valid @RequestBody SubCategoryDTO subCategoryDTO,@PathVariable("idSubCategory") Integer idSubCategory){
        Response<SubCategoryDTO> response = subCategoryService.updateSubCategory(subCategoryDTO,idSubCategory);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete_sub_category/{idSubCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<SubCategoryDTO>>deleteAddressByUser(@PathVariable("idSubCategory") Integer idSubCategory){
        Response<SubCategoryDTO> response = subCategoryService.deleteSubCategory(idSubCategory);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
