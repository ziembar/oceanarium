//package bada_oceanarium.SpringApplication;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DatabaseConfig {
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.oracle.database.jdbc:ojdbc11:23.2.0.0");
//        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
//        dataSource.setUsername( "BADAGRB18" );
//        dataSource.setPassword( "badagrb18" );
//        return dataSource;
//    }
//}