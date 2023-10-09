package com.h2.h2api.controladores;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.servicios.ServicioUsuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ControladorUsuarioTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void guardarUsuarioTest() throws Exception {
        // Simulamos un usuario sin carrito
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Usuario de Prueba");
        usuario.setEdad(30);
        usuario.setActivo(true);
        usuario.setFechaCreacion(LocalDateTime.now());

        // Cuando se llame a servicioUsuario.guardarUsuario, devolverá el usuario simulado
        when(servicioUsuario.guardarUsuario(usuario)).thenReturn(usuario);

        // Realizamos una solicitud POST para guardar el usuario
        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Usuario de Prueba"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.edad").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.activo").value(true));
    }

    @Test
    public void obtenerTodosLosUsuariosTest() throws Exception {
        // Simulamos una lista de usuarios
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNombre("Usuario 1");
        usuario1.setEdad(25);
        usuario1.setActivo(true);
        usuario1.setFechaCreacion(LocalDateTime.now());

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombre("Usuario 2");
        usuario2.setEdad(30);
        usuario2.setActivo(false);
        usuario2.setFechaCreacion(LocalDateTime.now());

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        // Cuando se llame a servicioUsuario.obtenerTodosLosUsuarios, devolverá la lista simulada de usuarios
        when(servicioUsuario.obtenerTodosLosUsuarios()).thenReturn(usuarios);

        // Realizamos una solicitud GET para obtener todos los usuarios
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("Usuario 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nombre").value("Usuario 2"));
    }
}
