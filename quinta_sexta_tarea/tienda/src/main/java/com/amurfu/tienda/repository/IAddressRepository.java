package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Integer> {


    List<Address> findByUserIdUser(Integer idUser);
}
