package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.CategoryDTO;
import com.amurfu.tienda.data.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryHelper implements ICategoryHelper{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO convertToDtoCategory(Category category) {
        return modelMapper.map(category,CategoryDTO.class);
    }
}
