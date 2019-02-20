package com.example.contract.controller;

import com.example.contract.ContractApplication;
import com.example.contract.model.User;
import com.example.contract.repository.UserRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractApplication.class)
public abstract class UserServiceBase {
    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setup() {
        User savedUser = new User();
        savedUser.setFirstName("John");
        savedUser.setLastName("Smith");
        savedUser.setId(12L);

        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        when(userRepository.findById(eq(12L))).thenReturn(Optional.of(savedUser));
    }

}
