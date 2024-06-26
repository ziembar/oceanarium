package bada_oceanarium.SpringApplication;

import bada_oceanarium.SpringApplication.DAOs.*;
import bada_oceanarium.SpringApplication.DTOs.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

//TODO: moze usuwanie userow jak bedzie czas
@Configuration
@Controller
public class AdminController implements WebMvcConfigurer {

    @Autowired
    private AdresyDAO adresyDAO;
    @Autowired
    private KarmyDAO karmyDAO;

    @Autowired
    private PracownicyDAO pracownicyDAO;

    @Autowired
    private ZadaniaDAO zadaniaDAO;


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

        String[] res = (String[])model.getAttribute("result");
        if (res != null){
            model.addAttribute("newUserId", res[0]);
            model.addAttribute("newUserUsername", res[1]);
            model.addAttribute("newUserPassword", res[2]);

        }


        String username = request.getRemoteUser();
        model.addAttribute("username", username);

        List<PracownicyDTO> pracusie = pracownicyDAO.list();


        List<AdresyDTO> adresy = adresyDAO.list();

        for(PracownicyDTO emply : pracusie){
            int idAdresu = Math.toIntExact(emply.getIdAdresu());
            emply.setAdres(adresy.get(idAdresu - 1));
        }
        model.addAttribute("pracownicy", pracusie);
        return "admin/employees";
    }
    @GetMapping("/addNewTask")
    public String showEmployeesForNewTask(Model model, HttpServletRequest request) {

        String username = request.getRemoteUser();
        model.addAttribute("username", username);

        List<PracownicyDTO> pracusie = pracownicyDAO.list();
        List<KarmyDTO> karma = karmyDAO.list();

        model.addAttribute("karmy", karma);
        model.addAttribute("pracownicy", pracusie);
        return "admin/addNewTask";
    }
    @RequestMapping(value = "/addNewTaskAction",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.PUT})
    public String showEmployeesForNewTask(
            @RequestParam("czestotliwosc") String czestotliwosc,
            @RequestParam("czyWykonane") String czyWykonane,
            @RequestParam("dataRozpoczecia")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataRozpoczecia,
            @RequestParam("dataZakonczenia")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataZakonczenia,
            @RequestParam("rodzajZadania") String rodzajZadania,
            @RequestParam(value = "karmaId", required = false) Long karmaId,
            @RequestParam(value = "pracownikId[]", required = false, defaultValue = "") List<Long> pracownikId,
            Model model, HttpServletRequest request) {
        Long idZadania = zadaniaDAO.createNew(czestotliwosc,czyWykonane, new java.sql.Date(dataRozpoczecia.getTime()),
                new java.sql.Date(dataZakonczenia.getTime()),rodzajZadania);
        if(!pracownikId.isEmpty()) {
            for (Long pracID : pracownikId) {
                zadaniaDAO.createNewZPP(idZadania, pracID, karmaId);
            }
        }
        return "redirect:/jobs";
    }
    @RequestMapping(value = "/addNewUserAction",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.PUT})
    public String addNewUser(@RequestParam("imie") String imie,
                             @RequestParam("nazwisko") String nazwisko,
                             @RequestParam("plec") String plec,
                             @RequestParam("pesel") String pesel,
                             @RequestParam("nrTelefonu") String nrTelefonu,
                             @RequestParam("email") String email,
                             @RequestParam("dataUrodzenia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUrodzenia,
                             @RequestParam("prawoJazdy") String prawoJazdy,
                             @RequestParam("miasto") String miasto,
                             @RequestParam("ulica") String ulica,
                             @RequestParam("numerDomu") String numerDomu,
                             @RequestParam("rola") String rola,
                             RedirectAttributes redirectAttributes) {
        Long idAdresu = adresyDAO.createForNewUser(miasto,ulica,numerDomu);
        String[] resultArr = pracownicyDAO.create(imie, nazwisko, plec, pesel, nrTelefonu, email,
                new java.sql.Date(dataUrodzenia.getTime()), prawoJazdy, idAdresu, rola);

        redirectAttributes.addFlashAttribute("result", resultArr);

        return "redirect:/employees";
    }

    @RequestMapping(value = "/deleteUsers", method = {RequestMethod.GET, RequestMethod.PUT}, produces = "application/json")
    public String deleteUsers(@RequestParam("idsToDelete") String[] idsToDelete){
        pracownicyDAO.deleteMany(idsToDelete);
        return "redirect:/employees";
    }





    @GetMapping("/jobs")
    public String jobs(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("username", username);

        List<ZadaniaPracowniczeDTO> zadania = zadaniaDAO.list();

        model.addAttribute("zadania", zadania);

        return "/admin/jobs";
    }


    @RequestMapping(value = "/deleteJob", method = {RequestMethod.GET, RequestMethod.PUT}, produces = "application/json")
    public String deleteJob(@RequestParam("jobId") String id){
        zadaniaDAO.delete(id);
        return "redirect:/jobs";
    }

}