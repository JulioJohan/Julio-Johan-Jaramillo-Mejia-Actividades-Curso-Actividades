package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.FormPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormPaymentRepository extends JpaRepository<FormPayment, Integer> {
}
