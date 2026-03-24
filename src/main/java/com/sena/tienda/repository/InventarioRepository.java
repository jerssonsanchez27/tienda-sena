package com.sena.tienda.repository;

import com.sena.tienda.entity.Bicicleta;
import com.sena.tienda.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    Optional<Inventario> findByBicicleta(Bicicleta bicicleta);
}