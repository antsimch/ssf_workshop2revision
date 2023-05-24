package sg.edu.nus.iss.ssf_workshop2revision.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.edu.nus.iss.ssf_workshop2revision.model.CONSTANTS;
import sg.edu.nus.iss.ssf_workshop2revision.model.Image;
import sg.edu.nus.iss.ssf_workshop2revision.service.RNGService;

@Controller
public class RNGController {

    @Autowired
    RNGService service;
    
    @GetMapping("/home")
    public String getLandingPage() {
        return "home";
    }

    @GetMapping("/get")
    public String getRandomNumbers(Model model, HttpServletRequest request) {

        int number = Integer.parseInt(request.getParameter("number"));

        // System.out.println(number);

        if ((number > CONSTANTS.MAX_VALUE) || (number < CONSTANTS.MIN_VALUE)) {

            String errorMessage = String.format("Number cannot be smaller than %d or greater than %d", CONSTANTS.MIN_VALUE, CONSTANTS.MAX_VALUE);
            model.addAttribute("errorMessage", errorMessage);
            return "home";
        }

        List<Integer> randomNumbers = service.generateRandomNumbers(number);

        List<Image> images = new ArrayList<>();
        
        for (int randomNumber : randomNumbers) {

            String name = Integer.toString(randomNumber);
            String path = String.format("/images/%d.png", randomNumber);

            Image image = new Image(name, path);
            images.add(image);
            // System.out.println(image);
        }

        // System.out.println(images);

        return "generate";
    }
}
