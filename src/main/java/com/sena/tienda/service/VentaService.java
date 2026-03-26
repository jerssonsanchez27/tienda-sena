package com.sena.tienda.service;

import com.sena.tienda.entity.*;
import com.sena.tienda.repository.DetalleVentaRepository;
import com.sena.tienda.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final ClienteService clienteService;
    private final BicicletaService bicicletaService;
    private final InventarioService inventarioService;

    public VentaService(
            VentaRepository ventaRepository,
            DetalleVentaRepository detalleVentaRepository,
            ClienteService clienteService,
            BicicletaService bicicletaService,
            InventarioService inventarioService
    ) {
        this.ventaRepository = ventaRepository;
        this.detalleVentaRepository = detalleVentaRepository;
        this.clienteService = clienteService;
        this.bicicletaService = bicicletaService;
        this.inventarioService = inventarioService;
    }

    public Venta registrarVenta(String documentoCliente, String codigoBicicleta, int cantidad) {

        if (documentoCliente == null || documentoCliente.trim().isEmpty()) {
            throw new RuntimeException("Documento del cliente es obligatorio");
        }

        if (codigoBicicleta == null || codigoBicicleta.trim().isEmpty()) {
            throw new RuntimeException("Código de bicicleta es obligatorio");
        }

        documentoCliente = documentoCliente.trim();
        codigoBicicleta = codigoBicicleta.trim();

        if (cantidad <= 0) {
            throw new RuntimeException("Cantidad inválida");
        }

        Cliente cliente = clienteService.buscarPorDocumento(documentoCliente);
        Bicicleta bicicleta = bicicletaService.buscarPorCodigo(codigoBicicleta);

        inventarioService.descontarStock(bicicleta, cantidad);

        double subtotal = bicicleta.getPrecio() * cantidad;

        DetalleVenta detalle = new DetalleVenta();
        detalle.setBicicleta(bicicleta);
        detalle.setCantidad(cantidad);
        detalle.setSubtotal(subtotal);

        List<DetalleVenta> detalles = new ArrayList<>();
        detalles.add(detalle);

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setDetalles(detalles);
        venta.setTotal(subtotal);

        Venta ventaGuardada = ventaRepository.save(venta);

        detalle.setVenta(ventaGuardada);
        detalleVentaRepository.save(detalle);

        return ventaGuardada;
    }
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }
}   