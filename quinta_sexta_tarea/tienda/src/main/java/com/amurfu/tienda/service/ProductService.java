package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.dto.Response;
import com.amurfu.tienda.data.entity.Category;
import com.amurfu.tienda.data.entity.Product;
import com.amurfu.tienda.data.entity.SubCategory;
import com.amurfu.tienda.exceptions.BusinessException;
import com.amurfu.tienda.exceptions.EntityNotFoundException;
import com.amurfu.tienda.helper.IProductHelper;
import com.amurfu.tienda.helper.IUserHelper;
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

        Product product = new Product();
        product.setNameProduct(productDTO.getNameProduct());
        product.setDescription(productDTO.getDescription());
        product.setSerial(productDTO.getSerial());
        product.setStatus(productDTO.getStatus());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());

        Optional<Category> category =  categoryRepository.findById(productDTO.getIdCategory());
        if(category.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.CATEGORY_NOT_FOUND);
        }
        Optional<SubCategory> subCategory =  subCategoryRepository.findById(productDTO.getIdSubCategory());
        if(subCategory.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND, Constants.SUB_CATEGORY_NOT_FOUND);
        }
        Optional<Product> productSerial =  productRepository.findBySerial(productDTO.getSerial());
        if (productSerial.isPresent()){
            throw new BusinessException(HttpStatus.BAD_REQUEST, Constants.PRODUCT_SERIAL);
        }
        product.setSubCategory(subCategory.get());
        product.setCategory(category.get());
        product = productRepository.save(product);
        productDTO.setIdProduct(product.getIdProduct());
        response.setData(productDTO);
        response.setMessage("El Producto se agrego correctamente");
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
        response.setMessage("Los Productos se obtenierón correctamente");
        return response;
    }

    @Override
    public Response<ProductDTO> getProductById(Integer idProduct) {
        Response<ProductDTO> response = new Response<>();

        Optional<Product> productOptional = productRepository.findById(idProduct);
        if (productOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.PRODUCT_NOT_FOUNT);
        }

        ProductDTO productDTO = productHelper.convertToDtoProduct(productOptional.get());
        response.setData(productDTO);
        response.setMessage("La consulta por producto se hizo correctamente");
        return response;
    }

    @Override
    public Response<ProductDTO> deleteProductById(Integer idProduct) {
        Response<ProductDTO> response = new Response<>();

        Optional<Product> productOptional = productRepository.findById(idProduct);
        if (productOptional.isEmpty()){
            throw new BusinessException(HttpStatus.NOT_FOUND,Constants.PRODUCT_NOT_FOUNT);
        }
        productRepository.deleteById(idProduct);
        response.setMessage("El Producto se elimino correctamente");
        response.setData(response.getData());
        return response;
    }

}
