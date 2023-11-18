package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Review,Integer> {
}
