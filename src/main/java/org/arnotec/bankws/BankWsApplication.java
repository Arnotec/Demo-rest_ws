package org.arnotec.bankws;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.entities.Customer;
import org.arnotec.bankws.entities.TypeAccount;
import org.arnotec.bankws.repositories.AccountRepository;
import org.arnotec.bankws.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BankWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankWsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository, CustomerRepository customerRepository) {
        return args -> {
            Customer c1 = new Customer(null, "Enzo", null);
            Customer c2 = new Customer(null, "Judith", null);

            customerRepository.save(c1);
            customerRepository.save(c2);

            accountRepository.save(new Account(null, Math.random()*90000, new Date(), TypeAccount.CURRENT, c1));
            accountRepository.save(new Account(null, Math.random()*90000, new Date(), TypeAccount.SAVINGS, c1));
            accountRepository.save(new Account(null, Math.random()*90000, new Date(), TypeAccount.CURRENT, c2));

            accountRepository.findAll().forEach(account -> {
                System.out.println(account.getSolde() + " - " + account.getType());
            });
        };
    }

}
