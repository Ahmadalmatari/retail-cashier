package com.example.retailcashier;

import com.example.retailcashier.models.CustomerType;
import com.example.retailcashier.models.Product;
import com.example.retailcashier.models.User;
import com.example.retailcashier.repositories.ProductRepository;
import com.example.retailcashier.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RetailCashierApplication {
private final ProductRepository productRepository;
private final UserRepository userRepository;
    public RetailCashierApplication(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RetailCashierApplication.class, args);
    }



    //Dummy data for testing on dev environment
    @PostConstruct
    public void preDefinedData(){
        List<Product> test = new ArrayList<>();
        User user = new User();
        user.setId(1l);
        user.setName("test");
        user.setCustomerType(CustomerType.EMPLOYEE);

        test.add(new Product(1L, "t1", BigDecimal.valueOf(100)));
        test.add(new Product(2L, "t2", BigDecimal.valueOf(200)));
        productRepository.saveAll(test);

        userRepository.save(user);
    }
}
