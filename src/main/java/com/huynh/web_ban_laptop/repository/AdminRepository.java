package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
}
