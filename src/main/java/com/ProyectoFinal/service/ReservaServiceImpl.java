package com.ProyectoFinal.service;

import com.ProyectoFinal.dao.ReservaDao;
import com.ProyectoFinal.domain.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;

    @Override
    public List<Reserva> getReservas(boolean activos) {
        var lista = (List<Reserva>) reservaDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    public Reserva getReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }
}
