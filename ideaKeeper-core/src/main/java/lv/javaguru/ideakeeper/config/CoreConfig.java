package lv.javaguru.ideakeeper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lv.javaguru.ideakeeper.database.DatabaseConfiguration;

@Configuration
@ComponentScan(basePackages = {"lv.javaguru.ideakeeper"})
@Import({DatabaseConfiguration.class})
public class CoreConfig {

    
    
}
