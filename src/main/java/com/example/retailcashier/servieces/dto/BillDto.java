package com.example.retailcashier.servieces.dto;

import com.example.retailcashier.models.CustomerType;
import com.example.retailcashier.models.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillDto {

    Long cartId;

    CustomerType customerType;

    List<Product> productList;

    BigDecimal totalAmount;
}
