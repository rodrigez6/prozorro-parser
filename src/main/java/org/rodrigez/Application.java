package org.rodrigez;

import org.rodrigez.controller.TendersLoader;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.rodrigez.repository")
public class Application {

    public static void main(String[] args){
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class).web(WebApplicationType.NONE);
        ApplicationContext context = app.run(args);
        //Loader contractsLoader = context.getBean(ContractsLoader.class);
        TendersLoader tendersLoader = context.getBean(TendersLoader.class);
        //contractsLoader.run();
        //tendersLoader.run();
        tendersLoader.loadTender("https://public.api.openprocurement.org/api/2.4/tenders/d6772968cd1d4f249402ec54f039627f");
        tendersLoader.loadTender("https://public.api.openprocurement.org/api/2.4/tenders/15fac6f3c01a464b998977957d594e93");
        tendersLoader.loadTender("https://public.api.openprocurement.org/api/2.4/tenders/f2678fe048a8442a812afe079277e99e");
        tendersLoader.loadTender("https://public.api.openprocurement.org/api/2.4/tenders/9bec0c35802e42048dadd7ad392e90d5");
        tendersLoader.loadTender("https://public.api.openprocurement.org/api/2.4/tenders/b77b7f77737348bd892b40609b18ca74");
        tendersLoader.loadTender("https://public.api.openprocurement.org/api/2.4/tenders/530a2bd777154e6ebd0225af226b10f6");
    }
}
