package bada_oceanarium.SpringApplication;

import bada_oceanarium.SpringApplication.DAOs.AdresyDAO;
import bada_oceanarium.SpringApplication.DAOs.BiletyDAO;
import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import bada_oceanarium.SpringApplication.DTOs.BiletyDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Date;

@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private AdresyDAO adresyDAO;
    @Autowired
    private BiletyDAO biletyDAO;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/tickets").setViewName("tickets");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/aquariums").setViewName("user/aquariums");
        registry.addViewController("/addNewFeed").setViewName("user/addNewFeed");
        registry.addViewController("/employees").setViewName("admin/employees");
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
        public String showTickets(Model model, HttpServletRequest request) {
            String username = request.getRemoteUser();
            model.addAttribute("username", username);

            List<BiletyDTO> bilety = biletyDAO.list();
            model.addAttribute("listaBiletow", bilety);

            return "/tickets";
        }
        @RequestMapping(  value = "/addTicket",
                produces = "application/json",
                method = {RequestMethod.GET, RequestMethod.PUT})
        public String addTicket(@RequestParam("idBiletu") Long idBiletu,
                                @RequestParam("dataWaznosci") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataWaznosci,
                                @RequestParam("idTypuBiletu") Long idTypuBiletu) {

            biletyDAO.addTicket(idBiletu, new java.sql.Date(dataWaznosci.getTime()), idTypuBiletu);
            return "redirect:/tickets";
        }
    }
}



