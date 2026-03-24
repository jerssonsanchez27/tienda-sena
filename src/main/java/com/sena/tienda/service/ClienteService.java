package com.sena.tienda.service;

import com.sena.tienda.entity.Cliente;
import com.sena.tienda.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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
}