package com.h2.h2api.servicios;

import com.h2.h2api.modelos.Usuario;

import java.util.List;

public interface ServicioUsuario {
    Usuario guardarUsuario(Usuario usuario);

    Usuario obtenerUsuario(Long idUsuario);

    Usuario usuarioAModificar(Long id, Usuario usuarioModificar);

    boolean eliminarUsuario(Long id);

    List<Usuario> obtenerTodosLosUsuarios();
}
