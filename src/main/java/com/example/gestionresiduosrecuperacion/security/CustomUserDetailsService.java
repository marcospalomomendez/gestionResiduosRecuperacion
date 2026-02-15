package com.example.gestionresiduosrecuperacion.security;

import com.example.gestionresiduosrecuperacion.model.Usuario;
import com.example.gestionresiduosrecuperacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import  java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar usuario en BD
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Convertir el rol de nuestro enum a un GrantedAuthority (con prefijo ROLE_)
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name());

        // Devolver un objeto User de Spring Security
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),  // la contraseña ya está hasheada en BD
                usuario.isActivo(),    // cuenta activa?
                true,                   // cuenta no expirada
                true,                   // credenciales no expiradas
                true,                   // cuenta no bloqueada
                Collections.singletonList(authority)  // lista de roles
        );
    }
}