package com.h2.h2api.servicios;

import com.h2.h2api.modelos.Carrito;
import com.h2.h2api.repositorios.RepositorioCarrito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServicioCarritoTest {

    @Mock
    private RepositorioCarrito repositorioCarrito;

    private ServicioCarrito servicioCarrito;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servicioCarrito = new ServicioCarritoImpl(repositorioCarrito);
    }

    @Test
    public void testGuardarCarrito() {
        // Configurar un carrito de prueba
        Carrito carrito = new Carrito();
        carrito.setId(1L);
        carrito.setCodigo("C123");
        carrito.setTotal(100.0);
        carrito.setFechaCompra(LocalDateTime.now());

        // Simular la llamada al repositorio
        when(repositorioCarrito.save(carrito)).thenReturn(carrito);

        // Llamar al método del servicio para guardar el carrito
        Carrito carritoGuardado = servicioCarrito.guardarCarrito(carrito);

        // Verificar que el carrito se haya guardado correctamente
        assertNotNull(carritoGuardado);
        assertEquals("C123", carritoGuardado.getCodigo());
        assertEquals(100.0, carritoGuardado.getTotal());

        // Verificar que se llamó al método save del repositorio
        verify(repositorioCarrito, times(1)).save(carrito);
    }

    @Test
    public void testObtenerCarritoPorId() {
        // Configurar un ID de carrito de prueba
        Long idCarrito = 1L;

        // Crear un carrito de prueba
        Carrito carrito = new Carrito();
        carrito.setId(idCarrito);
        carrito.setCodigo("C456");
        carrito.setTotal(200.0);
        carrito.setFechaCompra(LocalDateTime.now());

        // Simular la llamada al repositorio
        when(repositorioCarrito.findById(idCarrito)).thenReturn(Optional.of(carrito));

        // Llamar al método del servicio para obtener el carrito por su ID
        Carrito carritoObtenido = servicioCarrito.obtenerCarrito(idCarrito);

        // Verificar que se haya obtenido el carrito correctamente
        assertNotNull(carritoObtenido);
        assertEquals("C456", carritoObtenido.getCodigo());
        assertEquals(200.0, carritoObtenido.getTotal());

        // Verificar que se llamó al método findById del repositorio
        verify(repositorioCarrito, times(1)).findById(idCarrito);
    }
}