package com.example.gestionresiduosrecuperacion.controller;

import com.example.gestionresiduosrecuperacion.model.Asignacion;
import com.example.gestionresiduosrecuperacion.service.AsignacionService;
import com.example.gestionresiduosrecuperacion.service.CamionService;
import com.example.gestionresiduosrecuperacion.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @Autowired
    private CamionService camionService;

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public String listarAsignaciones(Model model) {
        List<Asignacion> asignaciones = asignacionService.findAll();
        model.addAttribute("asignaciones", asignaciones);
        return "asignaciones/listado";
    }

    @GetMapping("/nueva")
    public String formularioNuevaAsignacion(Model model) {
        model.addAttribute("camiones", camionService.findAll());
        model.addAttribute("rutas", rutaService.findAll());
        model.addAttribute("asignacion", new Asignacion());
        return "asignaciones/form";
    }

    @PostMapping("/guardar")
    public String guardarAsignacion(@RequestParam Long camionId,
                                    @RequestParam Long rutaId) {
        System.out.println("Guardando asignación: camionId=" + camionId + ", rutaId=" + rutaId);
        asignacionService.crearAsignacion(camionId, rutaId);
        return "redirect:/asignaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAsignacion(@PathVariable Long id) {
        asignacionService.eliminarAsignacion(id);
        return "redirect:/asignaciones";
    }
}