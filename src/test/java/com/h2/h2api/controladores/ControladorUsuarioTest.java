package com.h2.h2api.controladores;

import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.servicios.ServicioUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ControladorUsuario.class)
@ExtendWith(MockitoExtension.class)
@ComponentScan(basePackages = "com.h2.h2api.servicios")
public class ControladorUsuarioTest {

    @Mock
    private ServicioUsuario servicioUsuario;

    @InjectMocks
    private ControladorUsuario controladorUsuario;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controladorUsuario).build();
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testObtenerUsuario() throws Exception {
        // Simular el servicio
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Usuario de prueba");
        when(servicioUsuario.obtenerUsuario(1L)).thenReturn(usuario); // Usa 'when()' en lugar de 'Mock.when()'

        // Convertir el objeto Usuario a JSON
        String usuarioJson = asJsonString(usuario);

        // Realizar la solicitud HTTP y verificar la respuesta
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuarioJson)) // Pasar la cadena JSON como contenido
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Usuario de prueba"));
    }
}

/*
    @Test
    public void testGuardarUsuario() throws Exception {
        // Configurar un usuario de prueba
        Usuario usuario = new Usuario();
        usuario.setNombre("Ejemplo");
        usuario.setEdad(30);

        // Simular el servicio para guardar el usuario
        when(servicioUsuario.guardarUsuario(usuario)).thenReturn(usuario);

        // Realizar la solicitud HTTP para guardar el usuario
        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(usuario)))
                .andExpect(status().isCreated());

        // Verificar que se llamó al método para guardar el usuario en el servicio
        verify(servicioUsuario, times(1)).guardarUsuario(usuario);
    }
     */
