package com.sena.tienda.repository;

import com.sena.tienda.entity.Cliente;
import com.sena.tienda.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByCliente(Cliente cliente);
}