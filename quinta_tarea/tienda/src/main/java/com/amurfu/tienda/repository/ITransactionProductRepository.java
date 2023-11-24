package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.TransactionProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionProductRepository extends JpaRepository<TransactionProduct,Integer> {
}
