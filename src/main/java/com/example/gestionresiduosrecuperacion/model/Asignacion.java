package com.example.gestionresiduosrecuperacion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "asignaciones")
@Data
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "camion_id", nullable = false)
    private Camion camion;

    @ManyToOne
    @JoinColumn(name = "ruta_id", nullable = false)
    private Ruta ruta;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDate fechaAsignacion = LocalDate.now();
}
