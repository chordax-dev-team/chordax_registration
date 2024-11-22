package chordax_dev_team.chordax_registration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder()
                .group("user_operation-api")
                .packagesToScan("chordax_dev_team.chordax_registration.serviceuser.controller") // Specify the package to scan
                .build();
    }
}
