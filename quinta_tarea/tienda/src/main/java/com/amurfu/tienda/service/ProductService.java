package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Category;
import com.amurfu.tienda.data.entity.Product;
import com.amurfu.tienda.data.entity.SubCategory;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.helper.IProductHelper;
import com.amurfu.tienda.repository.ICategoryRepository;
import com.amurfu.tienda.repository.IProductRepository;
import com.amurfu.tienda.repository.ISubCategoryRepository;
import com.amurfu.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    ISubCategoryRepository subCategoryRepository;

    @Autowired
    IProductHelper productHelper;

    @Override
    public Response<ProductDTO> saveProduct(ProductDTO productDTO) {
        Response<ProductDTO> response = new Response<>();
              
        Category category = checkCategory(productDTO.getIdCategory());
        SubCategory subCategory = checkSubCategory(productDTO.getIdSubCategory());
        
        List<Product> listProduct =  productRepository.findBySerial(productDTO.getSerial());
        if (!listProduct.isEmpty()){
            throw new BusinessException(HttpStatus.BAD_REQUEST, Constants.PRODUCT_SERIAL);
        }                        
        Product product = new Product();
        product.setNameProduct(productDTO.getNameProduct());
        product.setDescription(productDTO.getDescription());
        product.setSerial(productDTO.getSerial());
        product.setStatus(productDTO.getStatus());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());      
        product.setSubCategory(subCategory);
        product.setCategory(category);
        product = productRepository.save(product);
        productDTO.setIdProduct(product.getIdProduct());
        response.setData(productDTO);
        response.setMessage(Constants.PRODUCT_SAVE);
        return response;
    }

    @Override
    public Response<ProductDTO> updateProduct(ProductDTO productDTO, Integer idProduct) {
        Response<ProductDTO> response = new Response<>();
        Optional<Product> optionalProduct = productRepository.findById(idProduct);
        if (optionalProduct.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.PRODUCT_NOT_FOUND);
        }      
        
        List<Product> listProduct =  productRepository.findBySerial(productDTO.getSerial());
        if (listProduct.size() > 1){
            throw new BusinessException(HttpStatus.BAD_REQUEST,Constants.PRODUCT_SERIAL);
        }    
                      
        Category category = checkCategory(productDTO.getIdCategory());
                          
        Product newProduct = optionalProduct.get();
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setSerial(productDTO.getSerial());
        newProduct.setCategory(category);                               
        newProduct.setStock(productDTO.getStock());
        newProduct.setStatus(productDTO.getStatus());
        newProduct.setPrice(productDTO.getPrice());        
        newProduct = productRepository.save(newProduct);
        productDTO = productHelper.convertToDtoProduct(newProduct); 
        response.setData(productDTO);
        response.setMessage(Constants.PRODUCT_UPDATE);
        return response;
    }

    @Override
    public Response<ProductDTO> getAllProduct() {
        Response<ProductDTO> response = new Response<>();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product: productRepository.findAll()){
            ProductDTO productDTO = productHelper.convertToDtoProduct(product);
            productDTOList.add(productDTO);
        }
        response.setList(productDTOList);
        response.setMessage(Constants.PRODUCTS_FOUND);
        return response;
    }

    @Override
    public Response<ProductDTO> getProductById(Integer idProduct) {
        Response<ProductDTO> response = new Response<>();

        Optional<Product> productOptional = productRepository.findById(idProduct);
        if (productOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.PRODUCT_NOT_FOUND);
        }

        ProductDTO productDTO = productHelper.convertToDtoProduct(productOptional.get());
        response.setData(productDTO);
        response.setMessage(Constants.PRODUCT_FOUND);
        return response;
    }

    @Override
    public Response<ProductDTO> deleteProductById(Integer idProduct) {
        Response<ProductDTO> response = new Response<>();

        Optional<Product> productOptional = productRepository.findById(idProduct);
        if (productOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(idProduct);
        response.setMessage(Constants.PRODUCT_DELETE);
        response.setData(response.getData());
        return response;
    }
    
//    Aplicando Principios SOLID, DRY
    private SubCategory checkSubCategory(Integer idSubCategory) {
    	 Optional<SubCategory> subCategory =  subCategoryRepository.findById(idSubCategory);
         if(subCategory.isEmpty()){
             throw new BusinessException(HttpStatus.NOT_FOUND, Constants.SUB_CATEGORY_NOT_FOUND);
         }
         return subCategory.get();
    }
    
    private Category checkCategory(Integer idProduct) {
    	 Optional<Category> category =  categoryRepository.findById(idProduct);
         if(category.isEmpty()){
             throw new BusinessException(HttpStatus.NOT_FOUND, Constants.CATEGORY_NOT_FOUND);
         }
         return category.get();
    }

}
