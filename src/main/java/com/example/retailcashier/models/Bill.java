package com.example.retailcashier.models;

import lombok.Data;

import java.util.List;

@Data
public class Bill {

    Cart cart;

    CustomerType customerType;

    List<Products> products;
    Double amount;

    public Bill() {
    }

    public Bill(Cart cart, CustomerType customerType, List<Products> products, Double amount) {
        this.cart = cart;
        this.customerType = customerType;
        this.products = products;
        this.amount = amount;
    }
}
