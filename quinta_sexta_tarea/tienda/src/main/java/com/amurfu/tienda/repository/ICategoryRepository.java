package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
