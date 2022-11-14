package com.ProyectoFinal.service;

import com.ProyectoFinal.dao.ParqueNacionalDao;
import com.ProyectoFinal.domain.ParqueNacional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParqueNacionalServiceImpl implements ParqueNacionalService {

    @Autowired
    private ParqueNacionalDao parqueNacionalDao;

    @Override
    public ParqueNacional getParqueNacional(ParqueNacional articulo) {
        return parqueNacionalDao.findById(articulo.getIdParqueNacional()).orElse(null);
    }

    @Override
    public void save(ParqueNacional articulo) {
        parqueNacionalDao.save(articulo);
    }

    @Override
    public void delete(ParqueNacional articulo) {
        parqueNacionalDao.delete(articulo);
    }

    @Override
    public List<ParqueNacional> getParqueNacionals(boolean activos) {
        var lista = (List<ParqueNacional>) parqueNacionalDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

}
