package com.ProyectoFinal.controller;

import com.ProyectoFinal.domain.Admin;
import com.ProyectoFinal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/listado")
    public String inicio(Model model) {
        var admins = adminService.getAdmins(false);
        model.addAttribute("admins", admins);
        return "/admin/listado";
    }

    @GetMapping("/admin/nuevo")
    public String nuevoAdmin(Model model) {
        model.addAttribute("categorias");
        return "/admin/modificar";
    }

    @PostMapping("/admin/guardar")
    public String guardarAdmin(Admin admin) {
        adminService.save(admin);
        return "redirect:/admin/listado";
    }

    @GetMapping("/admin/modificar/{idAdmin}")
    public String modificarAdmin(Admin admin, Model model) {
        admin = adminService.getAdmin(admin);
        model.addAttribute("admin", admin);
        return "/admin/modificar";
    }

    @GetMapping("/eliminarAdmin/{idAdmin}")
    public String elimnarAdmin(Admin admin) {
        adminService.delete(admin);
        return "redirect:/admin/listado";
    }

}
