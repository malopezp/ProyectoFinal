package com.ProyectoFinal.service;

import com.ProyectoFinal.domain.Reserva;
import java.util.List;

public interface ReservaService {

    public List<Reserva> getReservas(boolean activos);

    public Reserva getReserva(Reserva reserva);

    public void save(Reserva reserva);

    public void delete(Reserva reserva);

}
