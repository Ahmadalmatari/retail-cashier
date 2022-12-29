package com.example.retailcashier.servieces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDto {

    Long id;
    String productName;

    BigDecimal productAmount;
}
