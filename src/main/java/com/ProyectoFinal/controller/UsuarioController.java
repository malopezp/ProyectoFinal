package com.ProyectoFinal.controller;

import com.ProyectoFinal.domain.Usuario;
import com.ProyectoFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/listado")
    public String inicio(Model model) {
        var usuarios = usuarioService.getUsuarios(false);
        model.addAttribute("usuarios", usuarios);
        return "/usuario/listado";
    }

    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("categorias");
        return "/usuario/modificar";
    }

    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/usuario/modificar/{idUsuario}")
    public String modificarUsuario(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modificar";
    }

    @GetMapping("/eliminarUsuario/{idUsuario}")
    public String elimnarUsuario(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

}
