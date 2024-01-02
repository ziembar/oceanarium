package bada_oceanarium.SpringApplication;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        config.setUsername("BADAGRB18");
        config.setPassword("badagrb18");
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        System.out.println(dataSource);
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public InitializingBean dataSourceLogger(DataSource dataSource) {
        return new InitializingBean() {
            @Override
            public void afterPropertiesSet() {
                if (dataSource instanceof HikariDataSource) {
                    HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
                    System.out.println("HikariCP DataSource Details:");
                    System.out.println("JDBC URL: " + hikariDataSource.getJdbcUrl());
                    System.out.println("Username: " + hikariDataSource.getUsername());
                    // Add other properties you wish to log
                }
            }
        };
    }
}