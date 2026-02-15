package com.example.gestionresiduosrecuperacion.service;

import com.example.gestionresiduosrecuperacion.model.Asignacion;
import com.example.gestionresiduosrecuperacion.model.Camion;
import com.example.gestionresiduosrecuperacion.model.Ruta;
import com.example.gestionresiduosrecuperacion.repository.AsignacionRepository;
import com.example.gestionresiduosrecuperacion.repository.CamionRepository;
import com.example.gestionresiduosrecuperacion.repository.RutaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsignacionService {
    @Autowired
    private  AsignacionRepository asignacionRepository;
    @Autowired
    private  CamionRepository camionRepository;
    @Autowired
    private RutaRepository rutaRepository;

    public List<Asignacion> findAll(){
        return asignacionRepository.findAll();
    }

    @Transactional
    public Asignacion crearAsignacion(Long camionId, Long rutaId) {
        Camion camion = camionRepository.findById(camionId).orElseThrow();
        Ruta ruta = rutaRepository.findById(rutaId).orElseThrow();

        Asignacion asignacion = new Asignacion();
        asignacion.setCamion(camion);
        asignacion.setRuta(ruta);
        // fechaAsignacion se pone por defecto hoy

        return asignacionRepository.save(asignacion);
    }

    @Transactional
    public void eliminarAsignacion(Long id) {
        asignacionRepository.deleteById(id);
    }

}
