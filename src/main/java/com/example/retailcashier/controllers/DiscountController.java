package com.example.retailcashier.controllers;

import com.example.retailcashier.models.*;
import com.example.retailcashier.servieces.DiscountService;
import com.example.retailcashier.servieces.dto.CartDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/check-out")
    public Bill checkOut(@RequestBody CartDto cartDto) {

        log.debug("CheckOut The Cart");
        return discountService.checkOut(cartDto);
    }

}
