package dnd.team4backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Team4backendApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/dnd-5th-4-backend/real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(Team4backendApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
