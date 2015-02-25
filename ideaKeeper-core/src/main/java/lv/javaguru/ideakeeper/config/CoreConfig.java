package lv.javaguru.ideakeeper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lv.javaguru.ideakeeper.database.LiquibaseConfiguration;

@Configuration
@ComponentScan(basePackages = {"lv.javaguru.ideakeeper"})
@Import({
        AppPropertiesConfig.class,
        LiquibaseConfiguration.class,
        DataSourceConfig.class,
        HibernateConfig.class,
        TransactionConfig.class
})
public class CoreConfig {

    
    
}
