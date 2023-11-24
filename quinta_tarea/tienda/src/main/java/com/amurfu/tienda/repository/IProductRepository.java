package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product,Integer> {
   
    List<Product> findBySerial(String serial);
    
}
