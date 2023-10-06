package com.h2.h2api.controladores;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorCarritoTest {

    @Test
    void obtenerTodosLosCarritos() {
    }

    @Test
    void obtenerCarritoPorUsuario() {
    }
}

/*
package com.h2.h2api.controladores;

import com.h2.h2api.modelos.Carrito;
import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.servicios.ServicioCarrito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ControladorCarritoTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ServicioCarrito servicioCarrito;

    @InjectMocks
    private ControladorCarrito controladorCarrito;

    @Test
    public void testObtenerTodosLosCarritos() throws Exception {
        // Configurar datos de prueba
        Carrito carrito = new Carrito();
        carrito.setId(1L);
        List<Carrito> carritos = Collections.singletonList(carrito);

        // Mock del servicio
        when(servicioCarrito.obtenerTodosLosCarritos()).thenReturn(carritos);

        // Realizar la solicitud HTTP y verificar la respuesta
        mockMvc.perform(MockMvcRequestBuilders.get("/carritos/todoscarritos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }

    @Test
    public void testObtenerCarritoPorUsuario() throws Exception {
        // Configurar datos de prueba
        Long usuarioId = 1L;

        // Crear un objeto Usuario
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);

        // Crear un objeto Carrito
        Carrito carrito = new Carrito();
        carrito.setId(1L);

        // Mock del servicio
        when(servicioCarrito.obtenerCarritoPorUsuario(usuario)).thenReturn(carrito);

        // Realizar la solicitud HTTP y verificar la respuesta
        mockMvc.perform(MockMvcRequestBuilders.get("/carritos/usuario/{idUsuario}", usuarioId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

}

 */