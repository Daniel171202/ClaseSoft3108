package com.clase31.demo.dto;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.websocket.Decoder.Text;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class UsuarioDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column(length = 200)
    private String nombre;

    public UsuarioDTO() {
        // Default constructor with no arguments
    }
    
   

    // Constructor con parámetros
    public UsuarioDTO(long idUsuario,String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    // Getters y Setters
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Puedes agregar otros métodos según tus necesidades
    
    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
