package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.Account;
import sut.se.team11.repository.AccountRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(path = "/Login/{username}/{password}")
    private ResponseEntity<Account> login(@PathVariable String username, @PathVariable String password){
        Account a = accountRepository.findByUsernameAndPassword(username,password);
        if(a == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(a);
    }

    //Login
    @PutMapping(path = "/login/{accId}")
    private Account login(@PathVariable long accId){
        Account acc = accountRepository.findById(accId);

        acc.setLogin(true);
        return accountRepository.save(acc);
    }

    //Logout
    @PutMapping(path = "/logout/{accId}")
    private Account logout(@PathVariable long accId){
        Account acc = accountRepository.findById(accId);

        acc.setLogin(false);
        return accountRepository.save(acc);
    }

}
