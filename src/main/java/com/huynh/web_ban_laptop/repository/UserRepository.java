package com.huynh.web_ban_laptop.repository;


import com.huynh.web_ban_laptop.model.User;
import jakarta.persistence.Convert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("""
            update User u set u.email = ?1, u.name = ?2, u.password = ?3, u.phoneNumber = ?4, u.address = ?5, u.active = ?6 where u.id = ?7 and u.password = ?3""")
    void updateUser(@NonNull String email, @NonNull String name, String password, String phoneNumber, String address, Integer active, Integer id);

    @Query("select count(*) from User WHERE email = ?1 or phoneNumber = ?2")
    Long isUserExist(String email, String phoneNumber);

    @Query(value = "select id, email, name, phone_number, address, active from user  where (email = :email or phone_number = :phoneNumber) and password = :password ", nativeQuery = true)
    List<Map<String, Object>> getUserInfo(String email, String phoneNumber, String password);


/*    @Override
    @Query(value = "insert into us")
    default <S extends User> S save(S entity) {
        return null;
    }

    @Query(
           value = "insert into user values {}"
    )
    List<Map<String, Object>> addUserWithEmail(String email, String password);

 */
}