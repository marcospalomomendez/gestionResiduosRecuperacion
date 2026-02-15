package com.example.gestionresiduosrecuperacion.controller;

import com.example.gestionresiduosrecuperacion.model.Camion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.gestionresiduosrecuperacion.repository.CamionRepository;
import com.example.gestionresiduosrecuperacion.service.CamionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/camiones")
public class CamionController {

    @Autowired
    private CamionService camionService;

    @GetMapping
    public String listarCamiones(Model model) {
        List<Camion> camiones = camionService.findAll();
        model.addAttribute("camiones", camiones);
        return "camiones/listado";
    }
}