package com.huynh.web_ban_laptop.controler;

import com.huynh.web_ban_laptop.model.User;
import com.huynh.web_ban_laptop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    // Học về Dependencies Injection (nâng cao)
    @Autowired
    private UserRepository repository;

    // Lấy tất cả người dùng
    // Học về Java collection
    // ArrayList-> List -> Iterator
    @CrossOrigin
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getUsers() {
        return repository.findAll();
    }

    //Get user by id
    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable String id) {
        try {
            return repository.findById(Integer.parseInt(id)).get();
        } catch (Exception e) {
            return new User();
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object login(String email, String phoneNumber, String password)  {
        System.out.println(email);
        System.out.println(password);
        List<Map<String, Object>> result = repository.getUserInfo(email,phoneNumber, password);

        if (result.size() == 0) {
            return "null";
        }
        return  result.get(0);
    }


    // Học về POST, GET, DELETE, ... trong HTML
    // Dùng Postman để POST, hoặc dùng CURL nếu thích
    // Json là gì
    // API là gì
    // Viết tiếp các thêm sửa xóa khác

    //Edit user information
    @RequestMapping(
            path = "/edit",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public @ResponseBody String editUser(Integer id, String name, String password, String email, String phoneNumber, String address, Integer active) {
        try {
            repository.updateUser(email, name, password, phoneNumber, address, active != 0, id);
            return "User updated successfully";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    //Add new user
    @RequestMapping(
            path = "/add",
            method = RequestMethod.POST
    )
    public @ResponseBody String addUser(String email, String name, String password, String phoneNumber, String address, Integer active) {
        Long isUserExist = repository.isUserExist(email, phoneNumber);
        if (isUserExist > 0) {
            return "Add user failed";
        }

        if (email != null) {
            email = email.replaceAll("\"", "");
        }

        if (name != null) {
            name = name.replaceAll("\"", "");
        }

        if (password != null) {
            password = password.replaceAll("\"", "");
        }

        if (phoneNumber != null) {
             phoneNumber = phoneNumber.replaceAll("\"", "");
        }

        if (address != null) {
            address = address.replaceAll("\"", "");
        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setActive(active);

        repository.save(user);
        return "Add user success";
    }
}
