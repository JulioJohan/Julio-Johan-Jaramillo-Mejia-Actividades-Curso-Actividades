package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
}
