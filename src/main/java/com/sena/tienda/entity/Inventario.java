package com.sena.tienda.entity;

import com.sena.tienda.entity.Bicicleta;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;

    private Integer cantidadDisponible;
    private Integer stockMinimo;

    private LocalDateTime ultimaActualizacion;

    @OneToOne
    @JoinColumn(name = "id_bicicleta")
    private Bicicleta bicicleta;

    // getters y setters
}