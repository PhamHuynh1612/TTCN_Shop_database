package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.Cartitem;
import org.springframework.data.repository.CrudRepository;

public interface CartitemRepository extends CrudRepository<Cartitem, Integer> {
}