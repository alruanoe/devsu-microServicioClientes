/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.test.microservicioclientes.clientes.repository;

import com.devsu.test.microservicioclientes.clientes.entity.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ana Luisa Ruano Espina <a href="mailto:annaruanoespina@gmail.com">Ana
 * Ruano</a>
 */
public interface PersonaRepository extends CrudRepository<Persona, Long> {

    @Override
    Optional<Persona> findById(Long idPersona);

    boolean existsByIdPersona(Long idPersona);
    
    @Override
    List<Persona> findAll();
    
   
     @Query(value="select PERSONA_SQ.nextval from dual", nativeQuery=true)
    @Transactional(readOnly=true)
    public Integer getCorrelativo();


}
