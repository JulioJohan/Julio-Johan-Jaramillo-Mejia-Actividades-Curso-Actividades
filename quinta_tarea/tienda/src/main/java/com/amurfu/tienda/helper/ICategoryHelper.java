package com.amurfu.tienda.helper;

import com.amurfu.tienda.data.dto.CategoryDTO;
import com.amurfu.tienda.data.entity.Category;

public interface ICategoryHelper {

    CategoryDTO convertToDtoCategory(Category category);

}
