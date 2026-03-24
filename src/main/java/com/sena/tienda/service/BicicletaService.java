package com.sena.tienda.service;

import com.sena.tienda.entity.Bicicleta;
import com.sena.tienda.repository.BicicletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;

    public BicicletaService(BicicletaRepository bicicletaRepository) {
        this.bicicletaRepository = bicicletaRepository;
    }

    public Bicicleta guardar(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    public List<Bicicleta> listar() {
        return bicicletaRepository.findAll();
    }

    public Bicicleta buscarPorCodigo(String codigo) {
        return bicicletaRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }
}