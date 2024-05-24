package com.vivek.HostelManagement.restController;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/test")
    public String getTest(){
        return "This is test ";
    }
}
