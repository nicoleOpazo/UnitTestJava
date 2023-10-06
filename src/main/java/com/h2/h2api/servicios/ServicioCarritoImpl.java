package com.h2.h2api.servicios;

import com.h2.h2api.modelos.Carrito;
import com.h2.h2api.modelos.Usuario;
import com.h2.h2api.repositorios.RepositorioCarrito;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioCarritoImpl implements ServicioCarrito {
    private final RepositorioCarrito repositorioCarrito;

    @Override
    public Carrito guardarCarrito(Carrito carrito) {
        return repositorioCarrito.save(carrito);
    }

    @Override
    public Carrito obtenerCarrito(Long idCarrito) {
        return repositorioCarrito.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    @Override
    @Transactional
    public Carrito modificarCarrito(Long id, Carrito carritoModificar) {
        Carrito carritoBuscado = repositorioCarrito.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        carritoBuscado.setCodigo(carritoModificar.getCodigo());
        carritoBuscado.setTotal(carritoModificar.getTotal());
        carritoBuscado.setFechaCompra(carritoModificar.getFechaCompra());

        return carritoBuscado;
    }

    @Override
    public boolean eliminarCarrito(Long id) {
        try {
            repositorioCarrito.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Carrito> obtenerTodosLosCarritos() {
        return repositorioCarrito.findAll();
    }

    @Override
    public Carrito obtenerCarritoPorUsuario(Usuario usuario) {
        return repositorioCarrito.findCarritoByUsuario(usuario);
    }
}
