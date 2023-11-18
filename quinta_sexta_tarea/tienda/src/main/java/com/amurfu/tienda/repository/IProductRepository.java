package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product,Integer> {

    Optional<Product> findBySerial(String serial);
}
