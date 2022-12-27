package com.example.retailcashier.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Products {

    String id;

    String productName;

    Double productAmount;
}
