package com.h2.h2api.servicios;

import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.repositorios.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ServicioUsuarioImpl implements ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {
        return repositorioUsuario.findById(idUsuario)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    @Override
    public Usuario usuarioAModificar(Long id, Usuario usuarioModificar) {
        Usuario usuarioBuscado = repositorioUsuario.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioBuscado.setNombre(usuarioModificar.getNombre());
        usuarioBuscado.setEdad(usuarioModificar.getEdad());
        usuarioBuscado.setActivo(usuarioModificar.isActivo());

        return repositorioUsuario.save(usuarioBuscado);
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        try {
            repositorioUsuario.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return repositorioUsuario.findAll();
    }
}