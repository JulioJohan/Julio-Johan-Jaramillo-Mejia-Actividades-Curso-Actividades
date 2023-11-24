package com.amurfu.tienda.repository;

import com.amurfu.tienda.data.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {
}
