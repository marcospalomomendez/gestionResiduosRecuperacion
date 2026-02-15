package com.example.gestionresiduosrecuperacion.repository;

import com.example.gestionresiduosrecuperacion.model.Camion;
import com.example.gestionresiduosrecuperacion.model.EstadoCamion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CamionRepository  extends JpaRepository<Camion, Long> {

    List<Camion> findByEstadoCamion(EstadoCamion estado);

    List<Camion> findByActivoTrue();



}
