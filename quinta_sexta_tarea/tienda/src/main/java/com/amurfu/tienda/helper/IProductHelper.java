package com.amurfu.tienda.helper;


import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.entity.Product;

public interface IProductHelper {
    ProductDTO convertToDtoProduct(Product user);

}
