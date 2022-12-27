package com.example.retailcashier.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    String id;

    String name;

    CustomerType customerType;
}
