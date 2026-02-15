package com.example.gestionresiduosrecuperacion.repository;

import com.example.gestionresiduosrecuperacion.model.Asignacion;
import com.example.gestionresiduosrecuperacion.model.Camion;
import com.example.gestionresiduosrecuperacion.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {

    Optional<Camion> findByCamionId(Long camionId);

    Optional<Ruta> findByRutaId(Long rutaId);
}
