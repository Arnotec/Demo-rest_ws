package org.arnotec.bankws;

import org.arnotec.bankws.web.AccountRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public ResourceConfig jerseyConfig() {
        ResourceConfig jerseyConfig = new ResourceConfig();
        jerseyConfig.register(AccountRestJaxRSAPI.class);
        return jerseyConfig;
    }
}
