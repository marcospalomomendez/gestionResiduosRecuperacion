package com.example.gestionresiduosrecuperacion.controller;

import com.example.gestionresiduosrecuperacion.model.Ruta;
import com.example.gestionresiduosrecuperacion.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public String listarRutas(Model model) {
        List<Ruta> rutas = rutaService.findAll();

        model.addAttribute("rutas", rutaService.findAll());
        return "rutas/listado";
    }
}
