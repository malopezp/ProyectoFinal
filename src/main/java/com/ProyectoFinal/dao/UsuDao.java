package com.ProyectoFinal.dao;

import com.ProyectoFinal.domain.Usu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuDao extends JpaRepository<Usu, Long> {

    Usu findByUsername(String username);
}
