package com.ProyectoFinal.service;

import com.ProyectoFinal.dao.AdminDao;
import com.ProyectoFinal.domain.Admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAdmins(boolean activos) {
        var lista = (List<Admin>) adminDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return adminDao.findById(admin.getIdAdmin()).orElse(null);
    }

    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public void delete(Admin admin) {
        adminDao.delete(admin);
    }
}
