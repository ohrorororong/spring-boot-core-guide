package com.example.jpa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
@RequestMapping("/api")
public class SwaggerRedirectorController {

    @GetMapping
    public String api() {
        return "redirect:/swagger-ui/index.html";
    }
}
