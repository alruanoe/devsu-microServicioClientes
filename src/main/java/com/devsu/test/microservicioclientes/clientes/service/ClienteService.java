/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.test.microservicioclientes.clientes.service;

import com.devsu.test.microservicioclientes.clientes.entity.Cliente;
import com.devsu.test.microservicioclientes.clientes.repository.ClienteRepository;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

/**
 *
 * @author Ana Luisa Ruano Espina <a href="mailto:annaruanoespina@gmail.com">Ana
 * Ruano</a>
 */
@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository pRepo) {
        this.repo = pRepo;
    }

    /**
     *
     * @return {@code List<Cliente>}
     */
   public List<Cliente> listar() {
        return this.repo.findAll();
    }

    @Transactional
    public Cliente crear(Cliente pCliente) {
        Cliente creado;
        
        if (this.repo.existsByIdCliente(pCliente.getIdCliente())) {
            throw new IllegalArgumentException("El cliente ya existe");
        } else {
            creado = repo.save(pCliente);
        }
        return creado;

    }

    public Cliente obtenerCliente(Long pIdCliente) {
        return repo.findById(pIdCliente).orElseThrow(() -> new IllegalArgumentException("No existe cliente"));
    }

    @Transactional
    public Cliente actualizarCliente(Long pId, Cliente pCliente) {
        Cliente creado = obtenerCliente(pId);

        creado.setContrasena(pCliente.getContrasena());
        creado.setEstado(pCliente.getEstado());
        creado.setIdPersona(pCliente.getIdPersona());

        repo.save(creado);

        return creado;

    }

    @Transactional
    public void eliminar(Long pId) {
        Cliente creado = obtenerCliente(pId);
        repo.delete(creado);

    }
    
     public Integer getCorrelativo(){
        return repo.getCorrelativo();
    }

}
