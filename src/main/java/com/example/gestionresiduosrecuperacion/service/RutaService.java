package com.example.gestionresiduosrecuperacion.service;

import com.example.gestionresiduosrecuperacion.model.EstadoCamion;
import com.example.gestionresiduosrecuperacion.model.Ruta;
import com.example.gestionresiduosrecuperacion.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Service
public class RutaService {
    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> findAll(){
        return rutaRepository.findAll();
    }

    public List<Ruta> findByActivas(){
        return rutaRepository.findByActivaTrue();
    }

    public Optional<Ruta> findById(Long id){
        return rutaRepository.findById(id);
    }
}
