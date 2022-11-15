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
@Table(name = "admin")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    private String nombreAdmin;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private boolean activo;

    public Admin() {
    }

    public Admin(String nombreAdmin, String contrasena, String nombre, String apellido, String email, int telefono, boolean activo) {
        this.nombreAdmin = nombreAdmin;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
    }

}
