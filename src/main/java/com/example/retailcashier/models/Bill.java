package com.example.retailcashier.models;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @MapsId("cart_id")
    private Cart cart;

    @Column
    private CustomerType customerType;

    @OneToMany
    @Column
    private List<Product> products;

    @Column
    private BigDecimal amount;


}
