package org.arnotec.bankws.repositories;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.entities.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {

    @RestResource(path = "/byType")
    public List<Account> findByType(@Param("t") TypeAccount type);
}
