package org.rodrigez;

import org.rodrigez.service.TendersLoader;
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
        tendersLoader.run();
    }
}
