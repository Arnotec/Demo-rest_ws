package org.arnotec.bankws.web;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "/accountWS")
public class AccountSoapService {

    @Autowired
    private AccountRepository accountRepository;

    @WebMethod
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @WebMethod
    public Account getAccount(@WebParam(name = "id") Long id) {
        return accountRepository.findById(id).get();
    }

}
