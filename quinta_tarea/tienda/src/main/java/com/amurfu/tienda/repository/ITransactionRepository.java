package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {
}
