package com.sena.tienda.service;

import com.sena.tienda.entity.Cliente;
import com.sena.tienda.entity.Venta;
import com.sena.tienda.repository.ClienteRepository;
import com.sena.tienda.repository.DetalleVentaRepository;
import com.sena.tienda.repository.VentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;

    public ClienteService(ClienteRepository clienteRepository,
                          VentaRepository ventaRepository,
                          DetalleVentaRepository detalleVentaRepository) {
        this.clienteRepository = clienteRepository;
        this.ventaRepository = ventaRepository;
        this.detalleVentaRepository = detalleVentaRepository;
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorDocumento(String documento) {
        return clienteRepository.findByDocumento(documento)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Transactional
    public void eliminar(String documento) {
        Cliente cliente = buscarPorDocumento(documento);
        List<Venta> ventas = ventaRepository.findByCliente(cliente);

        // 1. Eliminar detalles de cada venta
        for (Venta venta : ventas) {
            detalleVentaRepository.deleteAll(venta.getDetalles());
        }

        // 2. Eliminar las ventas
        ventaRepository.deleteAll(ventas);

        // 3. Eliminar el cliente
        clienteRepository.delete(cliente);
    }
}