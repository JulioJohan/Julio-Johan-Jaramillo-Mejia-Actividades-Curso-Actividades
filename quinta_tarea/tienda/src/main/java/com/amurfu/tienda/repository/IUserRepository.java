package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(Long email);


}
