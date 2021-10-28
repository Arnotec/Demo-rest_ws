package org.arnotec.bankws;

import org.arnotec.bankws.entities.Account;
import org.arnotec.bankws.web.AccountRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class MyConfig {

    public MyConfig(RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Account.class);
    }

    //    @Bean
    public ResourceConfig jerseyConfig() {
        ResourceConfig jerseyConfig = new ResourceConfig();
        jerseyConfig.register(AccountRestJaxRSAPI.class);
        return jerseyConfig;
    }

    @Bean
    public SimpleJaxWsServiceExporter serviceExporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://0.0.0.0:8181");
        return exporter;
    }


}
