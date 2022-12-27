package com.example.retailcashier.servieces;

import com.example.retailcashier.models.Bill;
import com.example.retailcashier.models.Cart;
import com.example.retailcashier.models.CustomerType;
import com.example.retailcashier.models.Products;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public Object checkOut(Cart cart) {

        Bill bill = new Bill();
        if (cart.getProducts().isEmpty()){
            return "empty cart!!";
        }

        Double billTotalAmount = cart.getProducts().stream().map(Products::getProductAmount).reduce(0.0, Double::sum);

        if (cart.getUser().getCustomerType().equals(CustomerType.EMPLOYEE)) {
            billTotalAmount-=(billTotalAmount *0.3);
        } else if (cart.getUser().getCustomerType().equals(CustomerType.NORMAL_CUSTOMER)) {
            billTotalAmount-=(billTotalAmount * 0.1);
        }

        if ((billTotalAmount / 100) % 10 >= 1) {
            billTotalAmount -= ((billTotalAmount.intValue() / 100) % 10)*5;
        }

        bill.setCart(cart);
        bill.setAmount(billTotalAmount);
        bill.setProducts(cart.getProducts());
        bill.setCustomerType(cart.getUser().getCustomerType());

        return bill;
    }


}
