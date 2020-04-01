package com.academy.terai.controllers;

import com.academy.terai.exceptions.ApiRequestException;
import com.academy.terai.model.Account;
import com.academy.terai.model.request.AccountRequest;
import com.academy.terai.model.response.AccountResponse;
import com.academy.terai.service.AccountService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return accountService.findAll();
    }

    @GetMapping(value = "/{email}")
    public Account getAccountByEmail(@PathVariable("email") String email) throws ApiRequestException {
        return accountService.findByEmail(email);
    }

    @GetMapping(value = "/order/reviewed")
    public List<Account> findAllByOrderByReviewedApplicationsDesc() {
        return accountService.findAllByOrderByReviewedApplicationsDesc();
    }

    @PostMapping
    ResponseEntity<HttpStatus> createAccount(@RequestBody AccountRequest account) throws ApiRequestException {
        accountService.addAccount(account);
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }

    @PutMapping("/{id}")
    ResponseEntity<HttpStatus> updateAccount(@RequestBody Account account, @PathVariable String id) throws ApiRequestException {
        accountService.updateAccount(account, id);
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }

    @DeleteMapping(value = "/{email}")
    public void deleteStudent(@PathVariable String email) throws ApiRequestException {
        accountService.deleteAccount(accountService.findByEmail(email).getId());
    }
}