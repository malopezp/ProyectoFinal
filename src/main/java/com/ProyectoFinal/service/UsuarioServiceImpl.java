package com.ProyectoFinal.service;

import com.ProyectoFinal.dao.UsuarioDao;
import com.ProyectoFinal.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios(boolean activos) {
        var lista = (List<Usuario>) usuarioDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    public Usuario getUsuario(Usuario articulo) {
        return usuarioDao.findById(articulo.getIdUsuario()).orElse(null);
    }

    @Override
    public void save(Usuario articulo) {
        usuarioDao.save(articulo);
    }

    @Override
    public void delete(Usuario articulo) {
        usuarioDao.delete(articulo);
    }
}
