package com.example.gestionresiduosrecuperacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";  // nombre de la plantilla Thymeleaf (login.html)
    }

    @GetMapping("/acceso-denegado")
    public String accesoDenegado() {
        return "acceso-denegado";
    }
}
