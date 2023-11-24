package com.amurfu.tienda.service;

import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.dto.Response;

public interface IProductService {

    Response<ProductDTO> saveProduct(ProductDTO productDTO);

    Response<ProductDTO> updateProduct(ProductDTO productDTO,Integer idProduct);

    Response<ProductDTO> getAllProduct();

    Response<ProductDTO> getProductById( Integer idProduct);

    Response<ProductDTO> deleteProductById(Integer idProduct);
}
