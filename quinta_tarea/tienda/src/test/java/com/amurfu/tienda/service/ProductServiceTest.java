package com.amurfu.tienda.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.amurfu.tienda.data.entity.Product;
import com.amurfu.tienda.data.entity.SubCategory;
import com.amurfu.tienda.data.entity.SubCategoryTest;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.IProductHelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Category;
import com.amurfu.tienda.repository.ICategoryRepository;
import com.amurfu.tienda.repository.IProductRepository;
import com.amurfu.tienda.repository.ISubCategoryRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductService productService;
	
	@Mock
	IProductRepository productRepository;
	
	@Mock
    ICategoryRepository categoryRepository;
	
	@Mock
    ISubCategoryRepository subCategoryRepository;
	
    @Mock
	IProductHelper productHelper;
	
    Integer idProduct;
    Integer idCategory;
    Integer idSubCategory;


    
	Optional<Category> optionalCategory;
	Optional<SubCategory> optionalSubCategory;
	Optional<Product> optionalProduct;

	Category category;
	SubCategory subCategory;
	ProductDTO productDTO;
	Product product;
	
	List<Product> listProduct;
	List<Product> listProductEmpty;

	
	@BeforeEach
	void setUp() {
		idCategory = 1;
		idSubCategory = 1;
		
		product = new Product();
		product.setIdProduct(1);
		category = new Category();
		subCategory = new SubCategory();
		productDTO = new ProductDTO();
		productDTO.setDescription("Description");
		productDTO.setIdCategory(1);
		productDTO.setIdProduct(1);
		productDTO.setIdSubCategory(1);
		productDTO.setNameProduct("NameProduct");
		productDTO.setPrice(new BigDecimal("10"));
		productDTO.setSerial("Serial");
		productDTO.setStock(1);
		
		optionalCategory = Optional.of(category);
		optionalProduct = Optional.of(product);
		optionalSubCategory = Optional.of(subCategory);
		listProduct = new ArrayList<>();
		listProductEmpty = new ArrayList<>();
		listProduct.add(product);
		
	}
		
	private void checkCategoryTest() {
		when(categoryRepository.findById(productDTO.getIdCategory())).thenReturn(optionalCategory);
	}

	
	private void checkSubCategoryTest(){
		when(subCategoryRepository.findById(productDTO.getIdSubCategory())).thenReturn(optionalSubCategory);
	}
	
		
	private void checkProductTest() {
		when(productRepository.findById(idProduct)).thenReturn(optionalProduct);
	}

	@Test
	void saveProductTest() {
		checkCategoryTest();
		checkSubCategoryTest();
		when(productRepository.findBySerial(productDTO.getSerial())).thenReturn(listProductEmpty);
		when(productRepository.save(Mockito.any())).thenReturn(product);
		Response<ProductDTO> response = productService.saveProduct(productDTO);
		assertNotNull(response);
	}
	
	@Test
	void saveProductSerialETest() {
		checkCategoryTest();
		checkSubCategoryTest();
		when(productRepository.findBySerial(productDTO.getSerial())).thenReturn(listProduct);
		assertThrows(BusinessException.class, ()->{
			productService.saveProduct(productDTO);
		});
	}
	
	@Test
	void checkCategoryTestEmpty() {
		when(categoryRepository.findById(idCategory)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, ()->{
			productService.saveProduct(productDTO);
		});	
	}
	
	@Test
	void checkSubCategoryTestEmpty() {
		checkCategoryTest();
		when(subCategoryRepository.findById(idSubCategory)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, ()->{
			productService.saveProduct(productDTO);
		});	
	}
	
	@Test
	void updateProductTest() {
		checkProductTest();
		checkCategoryTest();
		when(productRepository.findBySerial(productDTO.getSerial())).thenReturn(listProductEmpty);
		when(productRepository.save(Mockito.any())).thenReturn(product);
		Response<ProductDTO> response = productService.updateProduct(productDTO,idProduct);
		assertNotNull(response);
	}
	
	@Test
	void updateProductEmptyTest() {
		when(productRepository.findById(idProduct)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, ()->{
			productService.updateProduct(productDTO,idProduct);
		});	
	}
	
	@Test
	void updateProductSerialTest() {
		checkProductTest();
		listProduct.add(product);
		when(productRepository.findBySerial(productDTO.getSerial())).thenReturn(listProduct);
//		Entrar a una excepcion
		assertThrows(BusinessException.class, ()->{
			productService.updateProduct(productDTO,idProduct);
		});	
	}

	
	@Test
	void getAllProductTest() {		
		when(productRepository.findAll()).thenReturn(listProduct);
		Response<ProductDTO> response = productService.getAllProduct();
		assertNotNull(response);
	}
	
	@Test
	void getProductByIdTest() {
		checkProductTest();
		Response<ProductDTO> response = productService.getProductById(idProduct);
		assertNotNull(response);
	}
	
	@Test
	void getProductByIdEmptyTest() {
		when(productRepository.findById(idProduct)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, ()->{
			productService.getProductById(idProduct);
		});		
	}
	
	@Test
	void deleteProductByIdTest(){
		checkProductTest();
		Response<ProductDTO> response = productService.deleteProductById(idProduct);
		assertNotNull(response);
	}
	
	@Test
	void deleteProductByIdEmptyTest() {
		when(productRepository.findById(idProduct)).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, ()->{
			productService.deleteProductById(idProduct);
		});		
	}
	
	


}
