package com.huynh.web_ban_laptop.controler;

import com.huynh.web_ban_laptop.model.Size;
import com.huynh.web_ban_laptop.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/size")
@CrossOrigin
public class SizeController {
    @Autowired
    SizeRepository sizeRepository;

    @GetMapping(path = "/all")
    @ResponseBody Iterable<Size>  getAll() {
        return sizeRepository.findAll();
    }
}
