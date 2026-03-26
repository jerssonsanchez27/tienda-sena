package com.sena.tienda.repository;

import com.sena.tienda.entity.Bicicleta;
import com.sena.tienda.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findByBicicleta(Bicicleta bicicleta);
}