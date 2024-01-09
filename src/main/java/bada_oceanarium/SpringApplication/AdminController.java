package bada_oceanarium.SpringApplication;

import bada_oceanarium.SpringApplication.DAOs.AdresyDAO;
import bada_oceanarium.SpringApplication.DAOs.AkwariaDAO;
import bada_oceanarium.SpringApplication.DAOs.PracownicyDAO;
import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
import bada_oceanarium.SpringApplication.DTOs.KarmyDTO;
import bada_oceanarium.SpringApplication.DTOs.PracownicyDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Controller
public class AdminController implements WebMvcConfigurer {

    @Autowired
    private AdresyDAO adresyDAO;

    @Autowired
    private PracownicyDAO pracownicyDAO;


    @GetMapping("/main_admin")
    public String showAdminPage(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("username", username);
        List<AdresyDTO> adresy = adresyDAO.list();
        model.addAttribute("adresy", adresy);
        return "admin/main_admin";
    }
    @GetMapping("/employees")
    public String showEmployees(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("username", username);

        List<PracownicyDTO> pracusie = pracownicyDAO.list();
        model.addAttribute("pracownicy", pracusie);

        List<AdresyDTO> adresy = adresyDAO.list();
        model.addAttribute("adresy", adresy);

        List<AdresyDTO> adresyPracownikow = new ArrayList<>();
        for(PracownicyDTO emply : pracusie){
            int idAdresu = Math.toIntExact(emply.getIdAdresu());
            emply.setAdres(adresy.get(idAdresu));
        }
        model.addAttribute("adresyPracownikow", adresyPracownikow);
        return "admin/employees";
    }
}