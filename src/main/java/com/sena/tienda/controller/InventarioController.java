package com.sena.tienda.controller;

import com.sena.tienda.entity.Inventario;
import com.sena.tienda.service.InventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public Inventario crear(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.listar();
    }
}