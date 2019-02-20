package com.example.contract.controller;

import com.example.contract.ContractApplication;
import com.example.contract.model.Account;
import com.example.contract.model.User;
import com.example.contract.repository.AccountRepository;
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
public abstract class AccountServiceBase {
    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setup() {
        Account account = new Account();
        account.setAccountName("John's Current Account");
        account.setBalance(250);
        account.setId(10L);
        account.setOwnerId(12L);

        when(accountRepository.save(any(Account.class))).thenReturn(account);
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        when(accountRepository.findById(eq(10L))).thenReturn(Optional.of(account));
    }

}
