package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
