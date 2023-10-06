package com.h2.h2api.servicios;

import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.repositorios.RepositorioUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ServicioUsuarioTest {

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private ServicioUsuarioImpl servicioUsuario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGuardarUsuario() {
        // Configurar un usuario de prueba
        Usuario usuario = new Usuario();
        usuario.setNombre("Ejemplo");
        usuario.setEdad(30);

        // Simular la llamada al repositorio
        when(repositorioUsuario.save(usuario)).thenReturn(usuario);

        // Llamar al método del servicio
        Usuario usuarioGuardado = servicioUsuario.guardarUsuario(usuario);

        // Verificar que el usuario se haya guardado correctamente
        assertNotNull(usuarioGuardado);
        assertEquals("Ejemplo", usuarioGuardado.getNombre());
        assertEquals(30, usuarioGuardado.getEdad());

        // Verificar que se llamó al método save del repositorio
        verify(repositorioUsuario, times(1)).save(usuario);
    }

    @Test
    public void testObtenerTodosLosUsuarios() {
        // Configurar una lista de usuarios de prueba
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "Usuario1", 25, true, LocalDateTime.now()));
        usuarios.add(new Usuario(2L, "Usuario2", 30, true, LocalDateTime.now()));

        // Simular la llamada al repositorio
        when(repositorioUsuario.findAll()).thenReturn(usuarios);

        // Llamar al método del servicio
        List<Usuario> usuariosObtenidos = servicioUsuario.obtenerTodosLosUsuarios();

        // Verificar que se hayan obtenido usuarios
        assertNotNull(usuariosObtenidos);
        assertEquals(2, usuariosObtenidos.size());

        // Verificar que se llamó al método findAll del repositorio
        verify(repositorioUsuario, times(1)).findAll();
    }
}
