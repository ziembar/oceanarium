package bada_oceanarium.SpringApplication;

import bada_oceanarium.SpringApplication.DAOs.AdresyDAO;
import bada_oceanarium.SpringApplication.DAOs.AkwariaDAO;
import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
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
@Controller
public class UserController implements WebMvcConfigurer {


    @Autowired
    private AkwariaDAO akwariaDAO;


    @GetMapping("/main_user")
    public String showUserPage(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("username", username);
        return "user/main_user";
    }

    @GetMapping("/aquariums")
    public String showAquariums(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("username", username);

        List<AkwariaDTO> akwaria = akwariaDAO.list();
        model.addAttribute("akwaria", akwaria);

        return "user/aquariums";
    }
}