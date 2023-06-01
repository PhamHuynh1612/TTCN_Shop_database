package com.huynh.web_ban_laptop.controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            var result =  repository.findById(Integer.parseInt(id));
            return result.orElse(null);
        } catch (Exception e) {
            return new User();
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object login(String email, String phoneNumber, String password) {

        System.out.println(email);
        System.out.println(phoneNumber);
        System.out.println(password);
        if(password == null) {
            return "null";
        }

        List<Map<String, Object>> result = repository.getUserInfo(email, phoneNumber, password);

        if (result.size() == 0) {
            return "null";
        }
        return result.get(0);
    }
    @RequestMapping(
            path = "/edit",
            method = RequestMethod.POST)
    public @ResponseBody Object editUser(@RequestBody String json) throws JsonProcessingException {
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user.getPassword());
        user.setPassword(user.getPassword().replaceAll("\"", ""));
            try {
                repository.save(user);
            } catch (Exception e) {
                System.out.println(e);
            }
            return Map.of(
                    "message" , "Update success"
            );
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
