package bada_oceanarium.SpringApplication;

import bada_oceanarium.SpringApplication.DAOs.AdresyDAO;
import bada_oceanarium.SpringApplication.DAOs.BiletyDAO;
import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import bada_oceanarium.SpringApplication.DTOs.BiletyDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

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
        registry.addViewController("/addNewTask").setViewName("admin/addNewTask");
        registry.addViewController("/employees").setViewName("admin/employees");
        registry.addViewController("/addNewUser").setViewName("admin/addNewUser");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/tickets_success").setViewName("tickets_success");
    }

    @Controller
    public class DashboardController {

        @RequestMapping("/main")
        public String defaultAfterLogin() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
                return "redirect:/main_admin";
            } else if (authentication.getAuthorities().toArray()[0].toString().equals("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }


        @GetMapping("/tickets")
        public String showTickets(Model model, HttpServletRequest request) {
            List<BiletyDTO> bilety = biletyDAO.list();
            model.addAttribute("listaBiletow", bilety);

            return "/tickets";
        }

        @RequestMapping(  value = "/addTicket",
                produces = "application/json",
                method = {RequestMethod.GET, RequestMethod.PUT})
                public String  addTicket(
                                @RequestParam("dataWaznosci") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataWaznosci,
                                @RequestParam("idTypuBiletu") Long idTypuBiletu,
                                RedirectAttributes redirectAttributes) {

            int result = biletyDAO.addTicket(new java.sql.Date(dataWaznosci.getTime()), idTypuBiletu);

            if (result!=-1) {
                redirectAttributes.addAttribute("result", Integer.toString(result));
                return("redirect:/tickets_success");
            }
            else {
                return ("redirect:/error");
            }
        }

        @RequestMapping(value = "/tickets_success")
        public String addTicketSuccess(@RequestParam("result") String id, Model model) {
            model.addAttribute("id", id);
            return "tickets_success";
        }

    }
}



