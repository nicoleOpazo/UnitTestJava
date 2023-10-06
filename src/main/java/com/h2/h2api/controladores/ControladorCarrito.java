package com.h2.h2api.controladores;

import com.h2.h2api.modelos.Carrito;
import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.servicios.ServicioCarrito;
import com.h2.h2api.servicios.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
@RequiredArgsConstructor
public class ControladorCarrito {

    private final ServicioCarrito servicioCarrito;
    private final ServicioUsuario servicioUsuario;

    /*@PostMapping()
    public ResponseEntity<Carrito> guardarCarrito(@RequestBody Carrito carritoDeUsuario) {
        if (carritoDeUsuario.getUsuario() != null) {
            carritoDeUsuario.getUsuario().setCarrito(carritoDeUsuario);
        }

        Carrito nuevoCarrito = servicioCarrito.guardarCarrito(carritoDeUsuario);
        return new ResponseEntity<>(nuevoCarrito, HttpStatus.CREATED);
    }*/

    @GetMapping("/{idCarrito}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable("idCarrito") Long idCarrito) {
        Carrito carrito = servicioCarrito.obtenerCarrito(idCarrito);
        return new ResponseEntity<>(carrito, HttpStatus.OK);
    }

    @PutMapping("/{idCarrito}")
    public ResponseEntity<Carrito> modificarCarrito(@PathVariable("idCarrito") Long idCarrito, @RequestBody Carrito carrito) {
        Carrito carritoModificado = servicioCarrito.modificarCarrito(idCarrito, carrito);
        return new ResponseEntity<>(carritoModificado, HttpStatus.OK);
    }

    /*@DeleteMapping("/{idCarrito}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable("idCarrito") Long idCarrito) {
        boolean eliminado = servicioCarrito.eliminarCarrito(idCarrito);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping("/todoscarritos")
    public ResponseEntity<List<Carrito>> obtenerTodosLosCarritos() {
        List<Carrito> carritos = servicioCarrito.obtenerTodosLosCarritos();
        return new ResponseEntity<>(carritos, HttpStatus.OK);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Carrito> obtenerCarritoPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        Usuario usuario = servicioUsuario.obtenerUsuario(idUsuario);
        Carrito carrito = servicioCarrito.obtenerCarritoPorUsuario(usuario);
        if (carrito != null) {
            return new ResponseEntity<>(carrito, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}