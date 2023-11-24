package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.SubCategoryDTO;

public interface ISubCategoryService {

    Response<SubCategoryDTO>getAllSubCategory();
    Response<SubCategoryDTO> saveSubCategory(SubCategoryDTO subCategoryDTO);
    Response<SubCategoryDTO> updateSubCategory(SubCategoryDTO subCategoryDTO, Integer idSubCategory);
    Response<SubCategoryDTO> deleteSubCategory(Integer idSubCategory);
    Response<SubCategoryDTO> getSubCategoryById(Integer idSubCategory);


}
