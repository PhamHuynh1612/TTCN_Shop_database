package com.huynh.web_ban_laptop.controler;

import com.huynh.web_ban_laptop.model.Color;
import com.huynh.web_ban_laptop.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/color")
@CrossOrigin
@Controller
public class ColorController {

    @Autowired
    ColorRepository colorRepository;

    @GetMapping(path = "/all")
    @ResponseBody
    Iterable<Color> getAll() {
        return colorRepository.findAll();
    }
}
