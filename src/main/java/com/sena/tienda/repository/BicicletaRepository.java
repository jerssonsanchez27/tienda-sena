package com.sena.tienda.repository;

import com.sena.tienda.entity.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {

    Optional<Bicicleta> findByCodigo(String codigo);
}