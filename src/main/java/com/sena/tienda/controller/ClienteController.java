package com.sena.tienda.controller;

import com.sena.tienda.entity.Cliente;
import com.sena.tienda.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @DeleteMapping("/{documento}")
    public void eliminar(@PathVariable String documento) {
        clienteService.eliminar(documento);
    }
}
