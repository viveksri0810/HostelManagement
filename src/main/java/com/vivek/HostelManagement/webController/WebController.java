package com.vivek.HostelManagement.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String getLandingPage(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/listProperties")
    public String getListProperties(){
        return "listProperties";
    }

    @GetMapping("/help")
    public String getHelp(){
        return "help";
    }


}
