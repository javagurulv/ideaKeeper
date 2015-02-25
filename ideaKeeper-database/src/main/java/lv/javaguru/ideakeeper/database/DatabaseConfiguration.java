package lv.javaguru.ideakeeper.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    @Value("${liquibase.update:true}")
    private boolean enabled;

    @Value("${liquibase.context:main}")
    private String context;
    

    @Bean
    public DatabaseMigrationService databaseMigrationService() {
        return new DatabaseMigrationServiceImpl(enabled, context);
    }
    
}
