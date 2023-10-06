package com.h2.h2api.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;


    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;
}
