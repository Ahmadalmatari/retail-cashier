package com.example.retailcashier;

import com.example.retailcashier.models.CustomerType;
import com.example.retailcashier.models.Product;
import com.example.retailcashier.models.User;
import com.example.retailcashier.repositories.CartRepository;
import com.example.retailcashier.repositories.UserRepository;
import com.example.retailcashier.servieces.dto.CartDto;
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

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
class DiscountControllerTests {

    protected MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    protected WebApplicationContext webApplicationContext;


    private final User user = new User();

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @BeforeEach
    void prepareTest() {


        user.setCustomerType(CustomerType.EMPLOYEE);
        user.setName("test");

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void checkOut() throws Exception {

        List<Product> test = new ArrayList<>();


        test.add(new Product(1L, "t1", BigDecimal.valueOf(100)));
        test.add(new Product(2L, "t2", BigDecimal.valueOf(200)));

        CartDto cart = new CartDto(1L,test);

        String json = objectMapper.writeValueAsString(cart);


        mockMvc.perform(MockMvcRequestBuilders.post("/check-out").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
