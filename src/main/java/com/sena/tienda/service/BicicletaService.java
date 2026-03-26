package com.sena.tienda.service;

import com.sena.tienda.entity.Bicicleta;
import com.sena.tienda.entity.Inventario;
import com.sena.tienda.repository.BicicletaRepository;
import com.sena.tienda.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;
    private final InventarioRepository inventarioRepository;

    public BicicletaService(BicicletaRepository bicicletaRepository,
                            InventarioRepository inventarioRepository) {
        this.bicicletaRepository = bicicletaRepository;
        this.inventarioRepository = inventarioRepository;
    }

    public Bicicleta guardar(Bicicleta bicicleta) {
        Bicicleta guardada = bicicletaRepository.save(bicicleta);

        // Crear registro de inventario automáticamente con stock 0
        Inventario inventario = new Inventario();
        inventario.setBicicleta(guardada);
        inventario.setStock(0);
        inventarioRepository.save(inventario);

        return guardada;
    }

    public List<Bicicleta> listar() {
        return bicicletaRepository.findAll();
    }

    public Bicicleta buscarPorCodigo(String codigo) {
        return bicicletaRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }

    public void eliminar(Long id) {
        bicicletaRepository.deleteById(id);
    }
}