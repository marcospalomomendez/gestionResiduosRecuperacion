package com.example.gestionresiduosrecuperacion.repository;

import com.example.gestionresiduosrecuperacion.model.EstadoCamion;
import com.example.gestionresiduosrecuperacion.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutaRepository extends JpaRepository<Ruta, Long> {

    List<Ruta> findByActivaTrue();
    List<Ruta> findByZona(String zona);
}
