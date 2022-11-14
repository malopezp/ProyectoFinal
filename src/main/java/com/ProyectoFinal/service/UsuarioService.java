package com.ProyectoFinal.service;

import com.ProyectoFinal.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    public List<Usuario> getUsuarios(boolean activos);

    public Usuario getUsuario(Usuario articulo);

    public void save(Usuario articulo);

    public void delete(Usuario articulo);

}
