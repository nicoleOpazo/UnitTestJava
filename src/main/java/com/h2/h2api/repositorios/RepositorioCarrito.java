package com.h2.h2api.repositorios;

import com.h2.h2api.modelos.Carrito;
import com.h2.h2api.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCarrito extends JpaRepository<Carrito, Long> {
    Carrito findCarritoByUsuario(Usuario usuario);
}
