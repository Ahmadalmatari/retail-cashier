package com.example.retailcashier;

import com.example.retailcashier.models.Cart;
import com.example.retailcashier.models.CustomerType;
import com.example.retailcashier.models.Products;
import com.example.retailcashier.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DiscountControllerTests {

    protected MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @BeforeEach
    void prepareTest() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void checkOut() throws Exception {

        List<Products> test = new ArrayList<>();


        test.add(new Products("1", "t1", 1.2));
        test.add(new Products("2", "t2", 2.2));

        User user = new User("1", "ahmad", CustomerType.EMPLOYEE);
        Cart cart = new Cart(user, test);

        String json = objectMapper.writeValueAsString(cart);

        mockMvc.perform(MockMvcRequestBuilders.post("/check-out").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
