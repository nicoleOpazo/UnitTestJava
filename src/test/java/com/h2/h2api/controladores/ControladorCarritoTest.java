package com.h2.h2api.controladores;

import com.h2.h2api.modelos.Carrito;
import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.servicios.ServicioCarrito;
import com.h2.h2api.servicios.ServicioUsuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class ControladorCarritoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioCarrito servicioCarrito;

    @MockBean
    private ServicioUsuario servicioUsuario;

    @Test
    public void obtenerCarritoDeUsuarioExistente() throws Exception {
        // Simulamos un usuario y un carrito
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Usuario de Prueba");

        Carrito carrito = new Carrito();
        carrito.setId(1L);
        carrito.setCodigo("COD123");
        carrito.setTotal(100.0);
        carrito.setFechaCompra(LocalDateTime.now());
        carrito.setUsuario(usuario);

        // Cuando se llame a servicioUsuario.obtenerUsuario, devolverá el usuario simulado
        when(servicioUsuario.obtenerUsuario(1L)).thenReturn(usuario);

        // Cuando se llame a servicioCarrito.obtenerCarritoPorUsuario, devolverá el carrito simulado
        when(servicioCarrito.obtenerCarritoPorUsuario(usuario)).thenReturn(carrito);

        // Realizamos una solicitud GET para obtener el carrito del usuario
        mockMvc.perform(MockMvcRequestBuilders.get("/carritos/usuario/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigo").value("COD123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(100.0));
    }

    @Test
    public void obtenerCarritoDeUsuarioNoExistente() throws Exception {
        // Simulamos un usuario que no existe
        when(servicioUsuario.obtenerUsuario(2L)).thenReturn(null);

        // Realizamos una solicitud GET para obtener el carrito de un usuario que no existe
        mockMvc.perform(MockMvcRequestBuilders.get("/carritos/usuario/2"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}