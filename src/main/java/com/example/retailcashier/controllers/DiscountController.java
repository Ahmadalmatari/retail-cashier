package com.example.retailcashier.controllers;

import com.example.retailcashier.models.*;
import com.example.retailcashier.servieces.DiscountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/check-out")
    public Object checkOut(@RequestBody Cart cart) {

        return discountService.checkOut(cart);
    }

}
