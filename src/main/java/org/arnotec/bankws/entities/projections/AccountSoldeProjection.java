package org.arnotec.bankws.entities.projections;

import org.arnotec.bankws.entities.Account;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde", types = {Account.class})
public interface AccountSoldeProjection {
    double getSolde();
}
