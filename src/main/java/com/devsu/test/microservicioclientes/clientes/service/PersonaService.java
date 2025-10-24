/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.test.microservicioclientes.clientes.service;

import com.devsu.test.microservicioclientes.clientes.entity.Cliente;
import com.devsu.test.microservicioclientes.clientes.entity.Persona;
import com.devsu.test.microservicioclientes.clientes.repository.ClienteRepository;
import com.devsu.test.microservicioclientes.clientes.repository.PersonaRepository;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

/**
 *
 * @author Ana Luisa Ruano Espina <a href="mailto:annaruanoespina@gmail.com">Ana
 * Ruano</a>
 */
@Service
public class PersonaService {

    private final PersonaRepository repo;

    public PersonaService(PersonaRepository pRepo) {
        this.repo = pRepo;
    }

    /**
     *
     * @return {@code List<Persona>}
     */
    public List<Persona> listar() {
        return this.repo.findAll();
    }

    @Transactional
    public Persona crear(Persona pPersona) {
        Persona creado;
        if (this.repo.existsById(pPersona.getIdPersona())) {
            throw new IllegalArgumentException("La persona ya existe");
        } else {
            creado = repo.save(pPersona);
        }
        return creado;

    }

    public Persona obtener(Long pId) {
        return repo.findById(pId).orElseThrow(() -> new IllegalArgumentException("No existe persona"));
    }

    @Transactional
    public Persona actualizar(Long pId, Persona pPersona) {
        Persona creado = obtener(pId);

        creado.setDireccion(pPersona.getDireccion());
        creado.setEdad(pPersona.getEdad());
        creado.setGenero(pPersona.getGenero());
        creado.setIdentificacion(pPersona.getIdentificacion());
        creado.setNombre(pPersona.getNombre());
        creado.setTelefono(pPersona.getTelefono());
        repo.save(creado);

        return creado;

    }

    @Transactional
    public void eliminar(Long pId) {
        Persona creado = obtener(pId);
        repo.delete(creado);

    }
    
    public Integer getCorrelativo(){
        return repo.getCorrelativo();
    }

}
