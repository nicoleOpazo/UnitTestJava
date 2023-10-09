package com.h2.h2api.repositorios;

import com.h2.h2api.modelos.Carrito;
import com.h2.h2api.modelos.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class RepositorioCarritoTest {

    @Autowired
    private RepositorioCarrito repositorioCarrito;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    public void testFindCarritoByUsuario() {
        // Crear un usuario y un carrito relacionado
        Usuario usuario = new Usuario();
        usuario.setNombre("Ejemplo");
        usuario.setEdad(30);
        usuario.setFechaCreacion(LocalDateTime.now());

        Carrito carrito = new Carrito();
        carrito.setCodigo("C123");
        carrito.setTotal(100.0);
        carrito.setFechaCompra(LocalDateTime.now());
        carrito.setUsuario(usuario);

        usuario.setCarrito(carrito);

        // Guardar el usuario y carrito en la base de datos
        usuario = repositorioUsuario.save(usuario);

        // Buscar el carrito por usuario
        Carrito carritoEncontrado = repositorioCarrito.findCarritoByUsuario(usuario);

        assertNotNull(carritoEncontrado);
    }

    @Test
    public void testFindCarritoByUsuarioUsuarioNoTieneCarrito() {
        // Crear un usuario sin un carrito relacionado
        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario Sin Carrito");
        usuario.setEdad(25);
        usuario.setFechaCreacion(LocalDateTime.now());

        // Guardar el usuario en la base de datos
        usuario = repositorioUsuario.save(usuario);

        // Buscar el carrito por usuario (debería devolver null)
        Carrito carritoEncontrado = repositorioCarrito.findCarritoByUsuario(usuario);

        assertNull(carritoEncontrado);
    }

}