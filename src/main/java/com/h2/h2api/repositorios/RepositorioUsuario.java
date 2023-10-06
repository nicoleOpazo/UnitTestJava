package com.h2.h2api.repositorios;

import com.h2.h2api.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}