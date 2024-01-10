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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//TODO: moze usuwanie userow jak bedzie czas
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
            emply.setAdres(adresy.get(idAdresu - 1));
        }
        model.addAttribute("adresyPracownikow", adresyPracownikow);
        return "admin/employees";
    }

    @RequestMapping(value = "/addNewUserAction",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.PUT})
    public String addNewFeed(@RequestParam("imie") String imie,
                             @RequestParam("nazwisko") String nazwisko,
                             @RequestParam("plec") String plec,
                             @RequestParam("pesel") String pesel,
                             @RequestParam("nrTelefonu") String nrTelefonu,
                             @RequestParam("email") String email,
                             @RequestParam("dataUrodzenia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUrodzenia,
                             @RequestParam("prawoJazdy") String prawoJazdy,
                             @RequestParam("miasto") String miasto,
                             @RequestParam("ulica") String ulica,
                             @RequestParam("numerDomu") String numerDomu) {
        Long idAdresu = adresyDAO.createForNewUser(miasto,ulica,numerDomu);
        pracownicyDAO.create(imie, nazwisko, plec, pesel, nrTelefonu, email,
                new java.sql.Date(dataUrodzenia.getTime()), prawoJazdy, idAdresu);

        return "redirect:/employees";
    }
}