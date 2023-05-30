package com.huynh.web_ban_laptop.controler;

import com.huynh.web_ban_laptop.model.Cartitem;
import com.huynh.web_ban_laptop.model.Shoppingsession;
import com.huynh.web_ban_laptop.repository.CartitemRepository;
import com.huynh.web_ban_laptop.repository.ShoppingsessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/session")
@CrossOrigin
public class ShoppingSessionController {
    @Autowired
    ShoppingsessionRepository shoppingsessionRepository;

    @Autowired
    CartitemRepository cartitemRepository;

    boolean isUserHasSession(Integer userId) {
        System.out.println(shoppingsessionRepository.getSessionCount(userId));
        return shoppingsessionRepository.getSessionCount(userId) > 0;
    }

    @PostMapping("/create")
    @ResponseBody
    Map<Object, Object> createShoppingSession(Integer userId) {
        if (isUserHasSession(userId)) {
            return Map.of(
                    "message", "user already has a session"
            );
        }

        Shoppingsession shoppingsession = new Shoppingsession();
        shoppingsession.setUser(userId);
        shoppingsessionRepository.save(shoppingsession);

        return Map.of(
                "message", "success"
        );
    }

    @PostMapping("/add-item")
    @ResponseBody
    Map<Object, Object> addItemToCart(Integer colorId, Integer productId, Integer quantity, Integer sessionId, Integer sizeId, Integer userId) {

        if(!isUserHasSession(userId)) {
             return Map.of(
                    "message" , "Session doesn't exist"
            );
        }

        Cartitem cartitem =  new Cartitem();
        System.out.println("Cart item created");
        cartitem.setId(999);
        cartitem.setColorId(colorId);
        cartitem.setProductId(productId);
        cartitem.setQuantity(quantity);
        cartitem.setSessionId(sessionId);
        cartitem.setSizeId(sizeId);
        cartitem.setUserId(userId);

        cartitemRepository.save(cartitem);
        return Map.of(
                "message" , "success"
        );
    }


}
