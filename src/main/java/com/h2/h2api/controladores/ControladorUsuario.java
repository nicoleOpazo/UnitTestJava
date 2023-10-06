package com.h2.h2api.controladores;

import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.servicios.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuarioConCarrito) {
        if (usuarioConCarrito.getCarrito() != null) {
            usuarioConCarrito.getCarrito().setUsuario(usuarioConCarrito);
        }

        Usuario nuevoUsuario = servicioUsuario.guardarUsuario(usuarioConCarrito);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long idUsuario) {
        Usuario usuario = servicioUsuario.obtenerUsuario(idUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario) {
        Usuario usuarioModificado = servicioUsuario.usuarioAModificar(idUsuario, usuario);
        return new ResponseEntity<>(usuarioModificado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Long idUsuario) {
        boolean eliminado = servicioUsuario.eliminarUsuario(idUsuario);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = servicioUsuario.obtenerTodosLosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}
