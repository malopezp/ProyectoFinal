package com.ProyectoFinal.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    private Long idReserva;
    private double monto;

    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @ManyToOne
    private Reserva reserva;

    public Factura() {
    }

}
