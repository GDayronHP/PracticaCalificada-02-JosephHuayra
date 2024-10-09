package com.joseph.practicaCalificada02.controladores;

import com.joseph.practicaCalificada02.modelos.entidades.Auditoria;
import com.joseph.practicaCalificada02.servicios.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping("/auditorias")
    public String listarAuditorias(Model model) {
        List<Auditoria> auditorias = auditoriaService.listar();
        model.addAttribute("auditorias", auditorias);
        return "auditorias";  // Nombre del template de Thymeleaf
    }
}
