package com.example.gestionresiduosrecuperacion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "camiones")
@Data
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 10)
    private String matricula;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(name = "capacidad_kg",nullable = false)
    private BigDecimal capacidadKg;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "estado")
    private EstadoCamion estadoCamion = EstadoCamion.DISPONIBLE;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;

    private boolean activo = true;

    @OneToMany(mappedBy = "camion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignacion> asignaciones = new ArrayList<>();
}
