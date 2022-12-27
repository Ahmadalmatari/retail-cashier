package com.example.retailcashier.controllers;

import com.example.retailcashier.models.*;
import com.example.retailcashier.servieces.DiscountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/check-out")
    public Object checkOut(@RequestBody Cart cart) {

        System.out.println(cart.getUser());
        System.out.println(cart.getProducts());
//        return cart;
        return discountService.checkOut(cart);

    }

    @GetMapping("/")
    public Cart test() {
        List<Products> test = new ArrayList<>();


        test.add(new Products("1", "t1", 1.2));
        test.add(new Products("2", "t2", 2.2));

        User user = new User("1", "ahmad", CustomerType.EMPLOYEE);
        Cart cart = new Cart(user, test);
        return cart;
    }
}
