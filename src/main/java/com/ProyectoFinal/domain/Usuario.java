package com.ProyectoFinal.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private boolean publicidad;
    private boolean activo;

    public Usuario() {
    }
    
    
    
    
}
