package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.CategoryDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Category;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.ICategoryHelper;
import com.amurfu.tienda.repository.ICategoryRepository;
import com.amurfu.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ICategoryHelper categoryHelper;

    @Override
    public Response<CategoryDTO> getCategoryById(Integer idCategory) {
        Response<CategoryDTO> response = new Response<>();
        Category category = checkCategoryExist(idCategory);
        CategoryDTO categoryDTO = categoryHelper.convertToDtoCategory(category);
        response.setData(categoryDTO);
        response.setMessage(Constants.CATEGORY_FOUND);
        return response;
    }

    @Override
    public Response<CategoryDTO> getAllCategories() {
        Response<CategoryDTO> response = new Response<>();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();

        if(categories.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.CATEGORY_NOT_FOUND);
        }

        for (Category category:categories){
            CategoryDTO categoryDTO = categoryHelper.convertToDtoCategory(category);
            categoryDTOList.add(categoryDTO);
        }

        response.setList(categoryDTOList);
        response.setMessage(Constants.CATEGORIES_FOUND);
        return response;
    }

    @Override
    public Response<CategoryDTO> saveCategory(CategoryDTO categoryDTO) {
        Response<CategoryDTO> response = new Response<>();
        Category category = new Category();
        category.setNameCategory(categoryDTO.getNameCategory());
        category = categoryRepository.save(category);
        categoryDTO = categoryHelper.convertToDtoCategory(category);
        response.setData(categoryDTO);
        response.setMessage(Constants.CATEGORY_SAVE);
        return response;
    }

    @Override
    public Response<CategoryDTO> updateCategory(CategoryDTO categoryDTO, Integer idCategory) {
        Response<CategoryDTO> response = new Response<>();
        Category category = checkCategoryExist(idCategory);
        category.setNameCategory(categoryDTO.getNameCategory());
        category = categoryRepository.save(category);
        categoryDTO = categoryHelper.convertToDtoCategory(category);
        response.setData(categoryDTO);
        response.setMessage(Constants.CATEGORY_UPDATE);
        return response;
    }

    @Override
    public Response<CategoryDTO> deleteCategory(Integer idCategory) {
        Response<CategoryDTO> response = new Response<>();
        Category category = checkCategoryExist(idCategory);
        categoryRepository.deleteById(idCategory);
        CategoryDTO categoryDTO = categoryHelper.convertToDtoCategory(category);
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category categoryTemp:categoryList){
            CategoryDTO categoryConvertDTO = categoryHelper.convertToDtoCategory(categoryTemp);
            categoryDTOList.add(categoryConvertDTO);
        }
        response.setList(categoryDTOList);
        response.setMessage(Constants.CATEGORY_DELETE);
        response.setData(categoryDTO);
        return response;
    }

//    Aplicando principios SOLID (DRY)
    private Category checkCategoryExist(Integer idCategory){
        Optional<Category> subCategoryOptional = categoryRepository.findById(idCategory);
        if (subCategoryOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.CATEGORY_NOT_FOUND);
        }
        return subCategoryOptional.get();
    }
}
