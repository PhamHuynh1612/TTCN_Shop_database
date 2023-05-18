package com.huynh.web_ban_laptop.controler;

import com.huynh.web_ban_laptop.model.User;
import com.huynh.web_ban_laptop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@Controller
@RequestMapping(path = "/user")
@CrossOrigin
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

    // lay nguoi dung qua id
    @GetMapping(path = "/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        try {
            return repository.findById(Integer.parseInt(id)).get();
        } catch (Exception e) {
            return new User();
        }
    }


    // Học về POST, GET, DELETE, ... trong HTML
    // Dùng Postman để POST, hoặc dùng CURL nếu thích
    // Json là gì
    // API là gì
    // Viết tiếp các thêm sửa xóa khác
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

    @RequestMapping(
            path = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )

    public @ResponseBody String addUser(String email, String name, String password, String phoneNumber, String address, Integer active) {
        Long isUserExist = repository.isUserExist(email, phoneNumber);
        if (isUserExist > 0) {
            return "Add user failed";
        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setActive(active != 0);

        repository.save(user);
        return "Add user success";
    }
}
