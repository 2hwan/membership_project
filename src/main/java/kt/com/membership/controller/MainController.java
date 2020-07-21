package kt.com.membership.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController implements ErrorController {

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/error")
    public String redirectRoot(){
        return "index";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
