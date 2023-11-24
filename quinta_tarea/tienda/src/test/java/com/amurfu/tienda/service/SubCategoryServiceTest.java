package com.amurfu.tienda.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.amurfu.tienda.data.entity.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.dto.SubCategoryDTO;
import com.amurfu.tienda.data.entity.Category;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.ISubCategoryHelper;
import com.amurfu.tienda.repository.ICategoryRepository;
import com.amurfu.tienda.repository.ISubCategoryRepository;

@ExtendWith(MockitoExtension.class)
public class SubCategoryServiceTest {

	@InjectMocks
	SubCategoryService subCategoryService;
		
	@Mock
	ICategoryRepository categoryRepository;
	
	@Mock
	ISubCategoryRepository subCategoryRepository;

	@Mock
    ISubCategoryHelper subCategoryHelper;

	Integer idCategory;
	Integer idSubCategory;

	
	Optional<Category> optionalCategory;
	Optional<SubCategory> optionalSubCategory;

	
	Category category;
	SubCategory subCategory;
	SubCategoryDTO subCategoryDTO;
	
	List<SubCategoryDTO> subCategoryDTOList;
	List<SubCategory> subCategoryList;
	@BeforeEach
	void setUp() {
	
		idCategory = 1;	
		idSubCategory = 1;
		
		category = new Category();
		subCategory = new SubCategory();
		subCategoryDTO = new SubCategoryDTO();		
		subCategoryDTO.setIdCategory(1);
		subCategoryDTO.setNameSubCategory("NameSubCategory");
		subCategoryDTO.setIdSubCategory(1);
		
		optionalCategory = Optional.of(category);
		optionalSubCategory = Optional.of(subCategory);
		
		subCategoryDTOList = new ArrayList<>();
		subCategoryList = new ArrayList<>();
		
		subCategoryDTOList.add(subCategoryDTO);
		subCategoryList.add(subCategory);
	}
	
	private void categoryExistTest() {
		when(categoryRepository.findById(idCategory)).thenReturn(optionalCategory);
	}
	
	private void subCategoryExistTest() {
		when(subCategoryRepository.findById(idSubCategory)).thenReturn(optionalSubCategory);
	}
	
	@Test
	void getAllSubCategoryTest() {				
		when(subCategoryRepository.findAll()).thenReturn(subCategoryList);	
		Response<SubCategoryDTO> response = subCategoryService.getAllSubCategory();
		assertNotNull(response);		
	}
	
	@Test
	void getAllSubCategoryEmptyTest() {		
		Response<SubCategoryDTO> response = subCategoryService.getAllSubCategory();
		assertNotNull(response);		
	}
	
	@Test
	void saveSubCategoryTest() {
		categoryExistTest();
		Response<SubCategoryDTO> response = subCategoryService.saveSubCategory(subCategoryDTO);
		assertNotNull(response);		
	}
	
	@Test
	void saveSubCategoryEmptyCategoryTest() {
        when(categoryRepository.findById(subCategoryDTO.getIdCategory())).thenReturn(Optional.empty());
		assertThrows(BusinessException.class,()->{			
			subCategoryService.saveSubCategory(subCategoryDTO);
		});
	}
	
	@Test
	void updateSubCategoryTest() {
		categoryExistTest();
		subCategoryExistTest();
		Response<SubCategoryDTO> response = subCategoryService.updateSubCategory(subCategoryDTO,idCategory);
		assertNotNull(response);		
	}
	
	@Test
	void updateEmptySubCategoryTest() {
		when(categoryRepository.findById(idCategory)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class,()->{			
			subCategoryService.updateSubCategory(subCategoryDTO,idCategory);
		});				
	}
	
	@Test
	void deleteSubCategoryTest() {
		subCategoryExistTest();
		Response<SubCategoryDTO> response = subCategoryService.deleteSubCategory(idSubCategory);
		assertNotNull(response);		
	}
	
	@Test
	void getSubCategoryByIdTest() {
		subCategoryExistTest();
		Response<SubCategoryDTO> response = subCategoryService.getSubCategoryById(idSubCategory);
		assertNotNull(response);			
	}
	
	@Test
	void getSubCategoryEmptyByIdTest() {
		when(subCategoryRepository.findById(idSubCategory)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class,()->{			
			subCategoryService.getSubCategoryById(idSubCategory);
		});				
	}
	
	
	
	
}
