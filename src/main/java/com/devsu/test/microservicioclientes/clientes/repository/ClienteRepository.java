/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.test.microservicioclientes.clientes.repository;

import com.devsu.test.microservicioclientes.clientes.entity.Cliente;
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
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Optional<Cliente> findByIdentificador(Long idCliente);

    boolean existsByIdCliente(String idCliente);
    
    @Override
    List<Cliente> findAll();
    
    @Query(value="select CLIENTE_SQ.nextval from dual", nativeQuery=true)
    @Transactional(readOnly=true)
    public Integer getCorrelativo();
    
   
    


}
