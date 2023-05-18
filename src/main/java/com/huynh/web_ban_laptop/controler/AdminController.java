package com.huynh.web_ban_laptop.controler;

import com.huynh.web_ban_laptop.model.Admin;
import com.huynh.web_ban_laptop.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Admin> getAdmins() {
        // This returns a JSON or XML with the users
        return adminRepository.findAll();
    }

    @PostMapping("/add")
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
