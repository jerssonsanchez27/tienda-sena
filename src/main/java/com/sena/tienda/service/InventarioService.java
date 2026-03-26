package com.sena.tienda.service;

import com.sena.tienda.entity.Bicicleta;
import com.sena.tienda.entity.Inventario;
import com.sena.tienda.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public List<Inventario> listar() {
        return inventarioRepository.findAll();
    }

    public Inventario buscarPorBicicleta(Bicicleta bicicleta) {
        return inventarioRepository.findByBicicleta(bicicleta)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    public void descontarStock(Bicicleta bicicleta, int cantidad) {
        Inventario inventario = buscarPorBicicleta(bicicleta);

        if (inventario.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }

        inventario.setStock(inventario.getStock() - cantidad);
        inventarioRepository.save(inventario);
    }
    public Inventario agregarStock(Long id, int cantidad) {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        inventario.setStock(inventario.getStock() + cantidad);
        return inventarioRepository.save(inventario);
    }
}