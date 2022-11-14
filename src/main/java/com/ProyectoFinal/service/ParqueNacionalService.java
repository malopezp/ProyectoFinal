package com.ProyectoFinal.service;

import com.ProyectoFinal.domain.ParqueNacional;
import java.util.List;

public interface ParqueNacionalService {

    public List<ParqueNacional> getParqueNacionals(boolean activos);

    public ParqueNacional getParqueNacional(ParqueNacional parque);

    public void save(ParqueNacional parque);

    public void delete(ParqueNacional parque);

}
