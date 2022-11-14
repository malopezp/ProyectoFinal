package com.ProyectoFinal.service;

import com.ProyectoFinal.domain.Admin;
import java.util.List;

public interface AdminService {

    public List<Admin> getAdmins(boolean activos);

    public Admin getAdmin(Admin admin);

    public void save(Admin admin);

    public void delete(Admin admin);

}
