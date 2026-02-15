package com.example.gestionresiduosrecuperacion.service;

import com.example.gestionresiduosrecuperacion.model.Camion;
import com.example.gestionresiduosrecuperacion.model.EstadoCamion;
import com.example.gestionresiduosrecuperacion.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionService {

    @Autowired
    private CamionRepository camionRepository;

    public List<Camion> findAll() {
        return camionRepository.findAll();
    }

    public List<Camion> findByEstado(EstadoCamion estado) {
        return camionRepository.findByEstadoCamion(estado);
    }

    public Optional<Camion> findById(Long id) {
        return camionRepository.findById(id);
    }
}
