package com.ProyectoFinal.dao;

import com.ProyectoFinal.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Admin, Long> {
    
}
