package org.arnotec.bankws.web;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.repositories.AccountRepository;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Component
@Path("/bank")
public class AccountRestJaxRSAPI {

   private final AccountRepository accountRepository;

    public AccountRestJaxRSAPI(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Path("/accounts")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Path("/accounts/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Account getAccount(@PathParam("id") Long id) {
        return accountRepository.findById(id).get();
    }

    @Path("/accounts")
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Path("/accounts/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Account update(Account account, @PathParam("id") Long id) {
        account.setId(id);
        return accountRepository.save(account);
    }

    @Path("/accounts/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(Long id) {
        accountRepository.deleteById(id);
    }
}
