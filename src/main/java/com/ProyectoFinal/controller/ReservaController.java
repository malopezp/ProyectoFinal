package com.ProyectoFinal.controller;

import com.ProyectoFinal.domain.ParqueNacional;
import com.ProyectoFinal.domain.Reserva;
import com.ProyectoFinal.domain.Usuario;
import com.ProyectoFinal.service.ParqueNacionalService;
import com.ProyectoFinal.service.ReservaService;
import com.ProyectoFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ParqueNacionalService parqueNacionalService;

    @GetMapping("/reserva/listado")
    public String inicio(Model model) {
        var reservas = reservaService.getReservas(false);
        model.addAttribute("reservas", reservas);
        return "/reserva/listado";
    }

    @GetMapping("/reserva/nuevo")
    public String nuevoReserva(Usuario usuario, ParqueNacional parqueNacional, Model model) {
        var usuarios = usuarioService.getUsuarios(true); 
        var parqueNacionals = parqueNacionalService.getParqueNacionals(true); 
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("parqueNacionals", parqueNacionals);
        return "/reserva/modificar";
    }

    @PostMapping("/reserva/guardar")
    public String guardarReserva(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/reserva/modificar/{idReserva}")
    public String modificarReserva(Reserva reserva, Model model) {
        var usuarios = usuarioService.getUsuarios(true); 
        model.addAttribute("usuarios", usuarios);
        var parqueNacionals = parqueNacionalService.getParqueNacionals(true); 
        model.addAttribute("parqueNacionals", parqueNacionals);
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        return "/reserva/modificar";
    }

    @GetMapping("/eliminarReserva/{idReserva}")
    public String elimnarReserva(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

}
