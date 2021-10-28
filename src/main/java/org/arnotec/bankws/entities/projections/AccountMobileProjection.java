package org.arnotec.bankws.entities.projections;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.entities.TypeAccount;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "mobile", types = {Account.class})
public interface AccountMobileProjection {
    Date getDateCreation();
    TypeAccount getType();
}
