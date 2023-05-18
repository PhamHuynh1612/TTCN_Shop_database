package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}