package com.example.retailcashier.servieces;

import com.example.retailcashier.models.*;
import com.example.retailcashier.repositories.UserRepository;
import com.example.retailcashier.servieces.dto.CartDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class DiscountService {

    private final UserRepository userRepository;

    public DiscountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Bill checkOut(CartDto cartDto) {

        Bill bill = new Bill();

        User user = userRepository.findById(cartDto.getUserId()).get();

        Cart cart = new Cart();
        cart.setProducts(cartDto.getProductList());
        cart.setUser(user);

        BigDecimal billTotalAmount = cartDto.getProductList().stream().map(Product::getProductAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        if (user.getCustomerType().equals(CustomerType.EMPLOYEE)) {
            billTotalAmount = billTotalAmount.subtract(billTotalAmount.multiply(BigDecimal.valueOf(0.3)));
        } else if (user.getCustomerType().equals(CustomerType.NORMAL_CUSTOMER)) {
            billTotalAmount = billTotalAmount.subtract(billTotalAmount.multiply(BigDecimal.valueOf(0.1)));
        }

        int hundredCount = (billTotalAmount.divide(BigDecimal.valueOf(100)).intValue())%10;
        if (hundredCount >= 1) {
           billTotalAmount= billTotalAmount.subtract(BigDecimal.valueOf(hundredCount*5));
        }


        bill.setCart(cart);
        bill.setAmount(billTotalAmount);
        bill.setProducts(cartDto.getProductList());
        bill.setCustomerType(user.getCustomerType());

        return bill;
    }


}
