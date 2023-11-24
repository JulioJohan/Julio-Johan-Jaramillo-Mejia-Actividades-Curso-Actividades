package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.SubCategoryDTO;
import com.amurfu.tienda.data.entity.Category;
import com.amurfu.tienda.data.entity.SubCategory;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.ISubCategoryHelper;
import com.amurfu.tienda.repository.ICategoryRepository;
import com.amurfu.tienda.repository.ISubCategoryRepository;
import com.amurfu.tienda.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubCategoryService implements ISubCategoryService{

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    ISubCategoryRepository subCategoryRepository;

    @Autowired
    ISubCategoryHelper subCategoryHelper;

    @Override
    public Response<SubCategoryDTO> getAllSubCategory() {
        Response<SubCategoryDTO> response = new Response<>();
        List<SubCategoryDTO> subCategoryDTOList = new ArrayList<>();
        if(subCategoryRepository.findAll().isEmpty()){
            response.setMessage(Constants.SUBCATEGORIES_NOT_FOUND);
            response.setList(subCategoryDTOList);
            return response;
        }
        for (SubCategory subCategory: subCategoryRepository.findAll()){
            SubCategoryDTO subCategoryDTO = subCategoryHelper.convertToDtoSubCategory(subCategory);
            subCategoryDTOList.add(subCategoryDTO);
        }
        response.setList(subCategoryDTOList);
        response.setMessage(Constants.SUBCATEGORIES_FOUND);
        return response;
    }

    @Override
    public Response<SubCategoryDTO> saveSubCategory(SubCategoryDTO subCategoryDTO) {
        Response<SubCategoryDTO> response = new Response<>();

        Optional<Category> optionalCategory =  categoryRepository.findById(subCategoryDTO.getIdCategory());
        if(optionalCategory.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.CATEGORY_NOT_FOUND);
        }

        SubCategory subCategory  = new SubCategory();
        subCategory.setCategory(optionalCategory.get());
        subCategory.setNameSubCategory(subCategoryDTO.getNameSubCategory());
        subCategory = subCategoryRepository.save(subCategory);

        subCategoryDTO =  subCategoryHelper.convertToDtoSubCategory(subCategory);
        response.setData(subCategoryDTO);
        response.setMessage(Constants.SUBCATEGORY_SAVE);
        return response;
    }

    @Override
    public Response<SubCategoryDTO> updateSubCategory(SubCategoryDTO subCategoryDTO, Integer idSubCategory) {
        Response<SubCategoryDTO> response = new Response<>();

        Optional<Category> optionalCategory =  categoryRepository.findById(subCategoryDTO.getIdCategory());
        if(optionalCategory.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.CATEGORY_NOT_FOUND);
        }
        log.info("optionalCategory {}",optionalCategory.get());

        SubCategory subCategoryNew = checkSubCategoryExist(idSubCategory);
        subCategoryNew.setCategory(optionalCategory.get());
        subCategoryNew.setNameSubCategory(subCategoryDTO.getNameSubCategory());
        subCategoryNew = subCategoryRepository.save(subCategoryNew);

        subCategoryDTO = subCategoryHelper.convertToDtoSubCategory(subCategoryNew);
        response.setData(subCategoryDTO);
        response.setMessage(Constants.SUBCATEGORY_UPDATE);
        return response;
    }

    @Override
    public Response<SubCategoryDTO> deleteSubCategory(Integer idSubCategory) {
        Response<SubCategoryDTO> response = new Response<>();
        checkSubCategoryExist(idSubCategory);
        subCategoryRepository.deleteById(idSubCategory);
        return response;
    }

    @Override
    public Response<SubCategoryDTO> getSubCategoryById(Integer idSubCategory) {
        Response<SubCategoryDTO> response = new Response<>();
        SubCategory subCategory = checkSubCategoryExist(idSubCategory);
        SubCategoryDTO subCategoryDTO = subCategoryHelper.convertToDtoSubCategory(subCategory);
        response.setMessage(Constants.SUBCATEGORY_FOUND);
        response.setData(subCategoryDTO);
        return response;
    }

//    Aplicando los principios SOLID DRY
    private SubCategory checkSubCategoryExist(Integer idSubCategory){
        Optional<SubCategory> subCategoryOptional = subCategoryRepository.findById(idSubCategory);
        if (subCategoryOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.SUBCATEGORIES_NOT_FOUND);
        }
        return subCategoryOptional.get();
    }
}
