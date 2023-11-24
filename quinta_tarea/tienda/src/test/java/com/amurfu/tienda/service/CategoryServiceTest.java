package com.amurfu.tienda.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amurfu.tienda.data.dto.CategoryDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Category;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.ICategoryHelper;
import com.amurfu.tienda.repository.ICategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	
	@InjectMocks
	CategoryService categoryService;
	
	@Mock
	ICategoryRepository categoryRepository;
	
	@Mock
	ICategoryHelper categoryHelper;
	
	Integer idCategory;
	
	Category category;
	CategoryDTO categoryDTO;
	
	Optional<Category> optionalCategory;
	
	List<Category> listCategory;

	@BeforeEach
	void setUp() {
		category = new Category();
		categoryDTO = new CategoryDTO();	
		categoryDTO.setIdCategory(1);
		categoryDTO.setNameCategory("NameCategory");
		
		idCategory = 1;		
		optionalCategory = Optional.of(category);
		
		listCategory = new ArrayList<Category>();
		listCategory.add(category);
	}
	
	private void categoryExist() {
		when(categoryRepository.findById(idCategory)).thenReturn(optionalCategory);
	}
	
	@Test
	void getCategoryByIdTest() {
		categoryExist();
		Response<CategoryDTO> response = categoryService.getCategoryById(idCategory);
		assertNotNull(response);
	}
	
	@Test
	void getAllCategoriesTest() {
		when(categoryRepository.findAll()).thenReturn(listCategory);
		Response<CategoryDTO> response = categoryService.getAllCategories();
		assertNotNull(response);
	}
	
	@Test
	void getAllCategoriesEmptyTest() {
		assertThrows(BusinessException.class,()->{
			categoryService.getAllCategories();
		});
	}
	
	@Test
	void saveCategoryTest() {					
		categoryRepository.save(Mockito.any());
		Response<CategoryDTO> response = categoryService.saveCategory(categoryDTO);
		assertNotNull(response);
	}
	
	@Test
	void updateCategoryTest() {
		categoryExist();
		categoryRepository.save(Mockito.any());
		Response<CategoryDTO> response = categoryService.updateCategory(categoryDTO,idCategory);
		assertNotNull(response);
	}
	
	@Test
	void deleteCategoryTest() {
		categoryExist();
		categoryRepository.deleteById(Mockito.any());
		when(categoryRepository.findAll()).thenReturn(listCategory);
		Response<CategoryDTO> response = categoryService.deleteCategory(idCategory);
		assertNotNull(response);
	}
	
	@Test
	void checkCategoryExistTest(){		
		assertThrows(BusinessException.class,()->{
			categoryService.getCategoryById(idCategory);
		});
	}
	
}
