package com.huynh.web_ban_laptop.repository;

import com.huynh.web_ban_laptop.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("""
            update User u set u.email = ?1, u.name = ?2, u.password = ?3, u.phoneNumber = ?4, u.address = ?5, u.active = ?6 where u.id = ?7""")
    void updateUser(@NonNull String email, @NonNull String name, String password, String phoneNumber, String address, Boolean active, @NonNull Integer id);

    @Query("select count(*) from User WHERE email = ?1 or phoneNumber = ?2")
    Boolean isUserExist(String email, String phoneNumber);

    @Query("select email, name, address, phoneNumber from User where id = ?1")
    User getUserInfo(String id);
}