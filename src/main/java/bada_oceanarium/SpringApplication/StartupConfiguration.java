package bada_oceanarium.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfiguration {

    @Bean
    public CommandLineRunner logAdresyTable(DatabaseTableLogger databaseTableLogger) {
        return args -> {
            databaseTableLogger.logAdresyIds();
        };
    }
}