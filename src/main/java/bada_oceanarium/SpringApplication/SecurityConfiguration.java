package bada_oceanarium.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/index", "/tickets","/addTicket", "/error", "/webjars/**", "/img/**", "/css/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/addTicket").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/deleteUsers", "addNewUserAction").hasAuthority("ADMIN")
                        .requestMatchers("/main_admin","/employees","/addNewUser").hasAuthority("ADMIN")
                        .requestMatchers("/main_user", "aquariums","/feed","/addFeed","/addNewFeed","/producers").hasAuthority("USER")
                        .anyRequest().permitAll() //było auth ale nie dziala
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/main")
                        .permitAll()
                )
                .logout((logout) -> {
                    logout.permitAll();
                    logout.logoutSuccessUrl("/login");
                });

        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, 'Y' as enabled FROM pracownicy where username = ?")
                .authoritiesByUsernameQuery("SELECT username, role FROM pracownicy WHERE username = ?");
//                .getUserDetailsService();

    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}