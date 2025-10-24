/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.test.microservicioclientes.clientes.controller;

import com.devsu.test.microservicioclientes.clientes.entity.Cliente;
import com.devsu.test.microservicioclientes.clientes.service.ClienteService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ana Luisa Ruano Espina <a href="mailto:annaruanoespina@gmail.com">Ana
 * Ruano</a>
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService pService) {
        this.service = pService;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable Long id) {
        return service.obtenerCliente(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@Valid @RequestBody Cliente pCliente) {
        Cliente creado = service.crear(pCliente);
        return ResponseEntity.created(URI.create("/clientes/" + creado.getIdCliente())).body(creado);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @Valid @RequestBody Cliente pCliente) {
        Cliente creado = service.actualizarCliente(id, pCliente);
        return creado;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);

    }
}
