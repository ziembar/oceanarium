package bada_oceanarium.SpringApplication;

import bada_oceanarium.SpringApplication.DAOs.*;
import bada_oceanarium.SpringApplication.DTOs.AdresyDTO;
import bada_oceanarium.SpringApplication.DTOs.AkwariaDTO;
import bada_oceanarium.SpringApplication.DTOs.KarmyDTO;
import bada_oceanarium.SpringApplication.DTOs.ProducenciDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;
import java.util.List;

@Configuration
@Controller
public class UserController implements WebMvcConfigurer {


    @Autowired
    private AkwariaDAO akwariaDAO;
    @Autowired
    private KarmyDAO karmyDAO;
    @Autowired
    private ProducenciDAO producenciDAO;


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

    @GetMapping("/feed")
    public String showFeed(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("username", username);

        List<KarmyDTO> karmy = karmyDAO.list();
        model.addAttribute("karmy", karmy);

        return "user/feed";
    }
    @RequestMapping(value = "/handleFeedAction",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.PUT})
    public String addFeed(@RequestParam("idProduktu") Long idProduktu,
                          @RequestParam("quantity") int quantity,
                          @RequestParam("action") String action) {
        System.out.println(idProduktu +action+ quantity);

        if(action.equals("add")){
            karmyDAO.update_add(quantity,idProduktu);
        }
        else if(action.equals("use")){
            karmyDAO.update_use(quantity,idProduktu);
        }
        return "redirect:/feed"; // Przekierowanie z powrotem do strony karmienia
    }
    @RequestMapping(value = "/addNewFeedAction",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.PUT})
    public String addNewFeed(@RequestParam("nazwa") String nazwa,
                             @RequestParam("dataWaznosci") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataWaznosci,
                             @RequestParam("waga") Float waga,
                             @RequestParam("IDProducenta") Long IDProducenta) {
        karmyDAO.create(nazwa,new java.sql.Date(dataWaznosci.getTime()),waga,IDProducenta);
        return "redirect:/feed"; // Przekierowanie z powrotem do strony karmienia
    }
    @GetMapping("/producers")
    public ResponseEntity<List<ProducenciDTO>> getAllProducenci() {
        List<ProducenciDTO> producenci = producenciDAO.list();
        return ResponseEntity.ok(producenci);
    }
}