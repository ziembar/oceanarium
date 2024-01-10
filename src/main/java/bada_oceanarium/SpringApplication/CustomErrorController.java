package bada_oceanarium.SpringApplication;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = 0;
        if (status != null) {
            statusCode = Integer.valueOf(status.toString());
            model.addAttribute("statusCode", statusCode);
        }
        System.out.println();
            switch (statusCode) {
                case 403: {
                    model.addAttribute("message", "Forbidden page");
                    break;
                }
                case 404: {
                    model.addAttribute("message", "Page not found");
                    break;
                }
                case 500: {
                    model.addAttribute("message", "Forbidden page");
                    break;
                }
                case 504: {
                    model.addAttribute("message", "Gateway timeout");
                    break;
                }
                default: model.addAttribute("message", "Unknown error occurred");
            }
        return "error";
        }
}