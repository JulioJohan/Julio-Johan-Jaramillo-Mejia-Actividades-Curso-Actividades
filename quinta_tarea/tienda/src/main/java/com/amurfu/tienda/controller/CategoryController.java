package com.amurfu.tienda.controller;


import com.amurfu.tienda.data.dto.CategoryDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.service.ICategoryService;
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
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = {"enctype", "Authorization"} )
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(path = "/get_category_id/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<CategoryDTO>> getCategoryById(@PathVariable("idCategory") Integer idCategory){
        Response<CategoryDTO> response = categoryService.getCategoryById(idCategory);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping(path = "/get_all_category",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<CategoryDTO>>getAllCategories(){
        Response<CategoryDTO> response =categoryService.getAllCategories();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(path = "/save_category",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<CategoryDTO>> saveCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        Response<CategoryDTO> response = categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(path = "/update_category/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<CategoryDTO>> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,@PathVariable("idCategory") Integer idCategory){
        Response<CategoryDTO> response = categoryService.updateCategory(categoryDTO,idCategory);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_category/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<CategoryDTO>> deleteCategory(@PathVariable("idCategory") Integer idCategory){
        Response<CategoryDTO> response = categoryService.deleteCategory(idCategory);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
