package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.SubCategoryDTO;
import com.amurfu.tienda.data.entity.SubCategory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryHelper implements ISubCategoryHelper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubCategoryDTO convertToDtoSubCategory(SubCategory subCategory) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        Para identificar cual es el id de la categoria
        modelMapper.typeMap(SubCategory.class,SubCategoryDTO.class).addMappings(mapper ->{
           mapper.map(map-> map.getCategory().getIdCategory(), SubCategoryDTO::setIdCategory);
        });
        return modelMapper.map(subCategory,SubCategoryDTO.class);
    }
}
