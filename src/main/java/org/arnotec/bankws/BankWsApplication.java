package org.arnotec.bankws;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.entities.TypeAccount;
import org.arnotec.bankws.repositories.AccountRepository;
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
    CommandLineRunner start(AccountRepository accountRepository) {
        return args -> {
            accountRepository.save(new Account(null, Math.random()*90000, new Date(), TypeAccount.CURRENT));
            accountRepository.save(new Account(null, Math.random()*90000, new Date(), TypeAccount.SAVINGS));
            accountRepository.save(new Account(null, Math.random()*90000, new Date(), TypeAccount.CURRENT));

            accountRepository.findAll().forEach(account -> {
                System.out.println(account.getSolde() + " - " + account.getType());
            });
        };
    }

}
