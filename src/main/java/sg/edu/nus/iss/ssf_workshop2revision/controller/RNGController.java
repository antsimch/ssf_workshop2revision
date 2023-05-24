package sg.edu.nus.iss.ssf_workshop2revision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RNGController {
    
    @GetMapping("/home")
    public String getLandingPage() {
        return "home";
    }
}
