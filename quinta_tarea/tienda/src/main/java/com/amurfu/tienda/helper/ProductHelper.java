package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.ProductDTO;
import com.amurfu.tienda.data.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductHelper implements IProductHelper{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO convertToDtoProduct(Product product) {
        return  modelMapper.map(product,ProductDTO.class);
    }
}
