package com.example.gestionresiduosrecuperacion.repository;

import com.example.gestionresiduosrecuperacion.model.Rol;
import com.example.gestionresiduosrecuperacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    List<Usuario> findByRol(Rol rol);
}
