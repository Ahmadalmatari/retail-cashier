package com.example.retailcashier.servieces.dto;

import com.example.retailcashier.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    Long userId;

    List <Product> productList;
}
