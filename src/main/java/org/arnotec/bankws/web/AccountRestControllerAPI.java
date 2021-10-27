package org.arnotec.bankws.web;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.repositories.AccountRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/bank")
public class AccountRestControllerAPI {

   private final AccountRepository accountRepository;

    public AccountRestControllerAPI(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(path = "/accounts", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable("id") Long id) {
        return accountRepository.findById(id).get();
    }

    @PostMapping("/accounts")
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/accounts/{id}")
    public Account update(Account account, @PathVariable("id") Long id) {
        account.setId(id);
        return accountRepository.save(account);
    }

   @DeleteMapping("/accounts/{id}")
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
