package com.example.retailcashier.servieces.dto;

import com.example.retailcashier.models.CustomerType;
import lombok.Data;

@Data
public class UserDto {

    Long id;
    String name;

    CustomerType customerType;

}
