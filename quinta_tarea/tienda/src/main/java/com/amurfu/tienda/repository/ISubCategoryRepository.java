package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubCategoryRepository extends JpaRepository<SubCategory, Integer> {
}
