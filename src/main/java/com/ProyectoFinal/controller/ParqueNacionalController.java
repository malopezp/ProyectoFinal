package com.ProyectoFinal.controller;

import com.ProyectoFinal.domain.ParqueNacional;
import com.ProyectoFinal.service.ParqueNacionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParqueNacionalController {

    @Autowired
    private ParqueNacionalService parqueNacionalService;

    @GetMapping("/parqueNacional/listado")
    public String inicio(Model model) {
        var parqueNacionals = parqueNacionalService.getParqueNacionals(false);
        model.addAttribute("parqueNacionals", parqueNacionals);
        return "/parqueNacional/listado";
    }

    @GetMapping("/parqueNacional/nuevo")
    public String nuevoParqueNacional(Model model) {
        model.addAttribute("categorias");
        return "/parqueNacional/modificar";
    }

    @PostMapping("/parqueNacional/guardar")
    public String guardarParqueNacional(ParqueNacional parqueNacional) {
        parqueNacionalService.save(parqueNacional);
        return "redirect:/parqueNacional/listado";
    }

    @GetMapping("/parqueNacional/modificar/{idParqueNacional}")
    public String modificarParqueNacional(ParqueNacional parqueNacional, Model model) {
        parqueNacional = parqueNacionalService.getParqueNacional(parqueNacional);
        model.addAttribute("parqueNacional", parqueNacional);
        return "/parqueNacional/modificar";
    }

    @GetMapping("/eliminarParqueNacional/{idParqueNacional}")
    public String elimnarParqueNacional(ParqueNacional parqueNacional) {
        parqueNacionalService.delete(parqueNacional);
        return "redirect:/parqueNacional/listado";
    }

}
