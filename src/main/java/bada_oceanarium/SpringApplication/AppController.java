package bada_oceanarium.SpringApplication;

import bada_oceanarium.SpringApplication.DAOs.AdresyDAO;
import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private AdresyDAO adresyDAO;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/tickets").setViewName("tickets");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/aquariums").setViewName("user/aquariums");
    }

    @Controller
    public class DashboardController {

        @GetMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }


        @GetMapping("/tickets")
        public String showTicketsPage(Model model) {
            return "tickets";
        }
    }
}