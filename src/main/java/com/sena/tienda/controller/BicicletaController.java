package com.sena.tienda.controller;

import com.sena.tienda.entity.Bicicleta;
import com.sena.tienda.service.BicicletaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bicicletas")
public class BicicletaController {

    private final BicicletaService bicicletaService;

    public BicicletaController(BicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    @PostMapping
    public Bicicleta crear(@RequestBody Bicicleta bicicleta) {
        return bicicletaService.guardar(bicicleta);
    }

    @GetMapping
    public List<Bicicleta> listar() {
        return bicicletaService.listar();
    }
}