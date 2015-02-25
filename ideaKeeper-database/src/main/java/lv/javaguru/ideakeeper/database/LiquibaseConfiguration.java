package lv.javaguru.ideakeeper.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiquibaseConfiguration {

    @Bean
    public DatabaseMigrationService databaseMigrationService(@Value("${liquibase.update:false}") boolean dbUpdateEnabled,
                                                             @Value("${liquibase.context:main}") String liquibaseContext) {
        return new DatabaseMigrationServiceImpl(dbUpdateEnabled, liquibaseContext);
    }
    
}
