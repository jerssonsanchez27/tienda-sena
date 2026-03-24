package com.sena.tienda.controller;

import com.sena.tienda.dto.VentaRequest;
import com.sena.tienda.entity.Venta;
import com.sena.tienda.service.VentaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/test")
    public String test() {
        return "VentaController funcionando";
    }

    @PostMapping
    public Venta registrarVenta(@RequestBody VentaRequest request) {
        return ventaService.registrarVenta(
                request.getDocumentoCliente(),
                request.getCodigoBicicleta(),
                request.getCantidad()
        );
    }
}