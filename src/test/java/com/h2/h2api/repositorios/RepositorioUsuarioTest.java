package com.h2.h2api.repositorios;

import com.h2.h2api.modelos.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RepositorioUsuarioTest {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    public void testGuardarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario de prueba");
        usuario.setEdad(30);
        usuario.setActivo(true);
        usuario.setFechaCreacion(LocalDateTime.now());

        Usuario usuarioGuardado = repositorioUsuario.save(usuario);
        Assertions.assertNotNull(usuarioGuardado.getId());
    }

    @Test
    public void testObtenerUsuarioPorId() {
        // Crear un usuario de prueba y guardarlo en el repositorio
        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario de Prueba");
        usuario.setEdad(25);
        usuario.setActivo(true);
        usuario.setFechaCreacion(LocalDateTime.now());

        usuario = repositorioUsuario.save(usuario);

        // Obtener el usuario por ID
        Long usuarioId = usuario.getId();
        Usuario usuarioObtenido = repositorioUsuario.findById(usuarioId).orElse(null);

        // Verificar que se haya obtenido el usuario correctamente
        assertNotNull(usuarioObtenido);
        assertEquals("Usuario de Prueba", usuarioObtenido.getNombre());
        assertEquals(25, usuarioObtenido.getEdad());
        assertTrue(usuarioObtenido.isActivo());
    }
}
