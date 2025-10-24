/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.test.microservicioclientes.clientes.controller;

import com.devsu.test.microservicioclientes.clientes.entity.Persona;
import com.devsu.test.microservicioclientes.clientes.service.PersonaService;
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
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService pService) {
        this.service = pService;
    }

    @GetMapping
    public List<Persona> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Persona get(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public ResponseEntity<Persona> crear(@Valid @RequestBody Persona pPersona) {
        Persona creado = service.crear(pPersona);
        return ResponseEntity.created(URI.create("/personas/" + creado.getIdPersona())).body(creado);
    }

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @Valid @RequestBody Persona pPersona) {
        Persona creado = service.actualizar(id, pPersona);
        return creado;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);

    }
}
