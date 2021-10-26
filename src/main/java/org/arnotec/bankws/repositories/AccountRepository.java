package org.arnotec.bankws.repositories;

import org.arnotec.bankws.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
