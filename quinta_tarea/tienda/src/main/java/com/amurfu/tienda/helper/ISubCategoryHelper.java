package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.SubCategoryDTO;
import com.amurfu.tienda.data.entity.SubCategory;

public interface ISubCategoryHelper {

    SubCategoryDTO convertToDtoSubCategory(SubCategory subCategory);
}
