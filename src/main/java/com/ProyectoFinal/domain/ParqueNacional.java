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
@Table(name = "parque")
public class ParqueNacional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParqueNacional;
    private String nombre;
    private String horario;
    private double tarifa;
    private String ubicacion;
    private String servicios;
    private String atractivos;
    private boolean avistamientos;
    private boolean activo;

    public ParqueNacional() {
    }

}
