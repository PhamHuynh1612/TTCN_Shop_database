package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.Shoppingsession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingsessionRepository extends CrudRepository<Shoppingsession, Integer> {

    @Query(value = "select count(*) from shoppingsession where user_id = :userId", nativeQuery = true)
    Integer getSessionCount(Integer userId);
}