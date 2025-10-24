/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsu.test.microservicioclientes.clientes.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ana Luisa Ruano Espina <a href="mailto:alruano@gmail.com">Ana
 * Ruano</a>
 */

@Table(name = "CLIENTE")
@SequenceGenerator(name ="cliente_seq", sequenceName = "CLIENTE_SQ", allocationSize = 1)
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente_seq")
    @Column(name = "\"identificador\"")
    private Long identificador;
    @Size(min = 1, max = 50)
    @Column(name = "\"id_cliente\"", nullable = false, unique = true)
    private String idCliente;
    @Size(max = 250)
    @Column(name = "\"contrasena\"")
    private String contrasena;
    @Column(name = "\"estado\"")
    private Character estado;
    @JoinColumn(name = "\"id_persona\"", referencedColumnName = "id_persona")
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    private Persona idPersona;

    public Cliente() {
    }

    public Cliente(Long identificador) {
        this.identificador = identificador;
    }

    public Cliente(Long identificador, String idCliente) {
        this.identificador = identificador;
        this.idCliente = idCliente;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        return !((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador)));
    }

    @Override
    public String toString() {
        return "com.devsu.test.microservicioclientes.clientes.entity.Cliente[ identificador=" + identificador + " ]";
    }
    
}
