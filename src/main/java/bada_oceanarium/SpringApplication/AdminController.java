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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Controller
public class AdminController implements WebMvcConfigurer {

    @Autowired
    private AdresyDAO adresyDAO;

    @Autowired
    private AkwariaDAO akwariaDAO;


    @GetMapping("/main_admin")
    public String showAdminPage(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("username", username);
        List<AdresyDTO> adresy = adresyDAO.list();
        model.addAttribute("adresy", adresy);
        return "admin/main_admin";
    }
}