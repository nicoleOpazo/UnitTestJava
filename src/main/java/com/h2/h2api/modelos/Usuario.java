package com.h2.h2api.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    public Usuario(Long id, String nombre, int edad, boolean activo, LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }


    @OneToOne(mappedBy ="usuario", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Carrito carrito;

}