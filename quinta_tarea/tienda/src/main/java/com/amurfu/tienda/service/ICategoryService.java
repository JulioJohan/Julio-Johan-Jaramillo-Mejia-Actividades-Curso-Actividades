package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.CategoryDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Category;

public interface ICategoryService {

    Response<CategoryDTO> getCategoryById(Integer idCategory);
    Response<CategoryDTO> getAllCategories();
    Response<CategoryDTO> saveCategory(CategoryDTO category);
    Response<CategoryDTO> updateCategory(CategoryDTO categoryDTO, Integer idCategory);
    Response<CategoryDTO> deleteCategory(Integer idCategory);

}
