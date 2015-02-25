package lv.javaguru.ideakeeper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by Viktor on 25/02/2015.
 */
@Configuration
public class AppPropertiesConfig {

    private static final String PROPERTIES_FILE_NAME = "database.properties";

    @Bean
    public static PropertySourcesPlaceholderConfigurer prodPropertiesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        Resource[] resourceLocations = new Resource[] {
                new ClassPathResource(PROPERTIES_FILE_NAME)
        };
        p.setLocations(resourceLocations);
        return p;
    }

}
