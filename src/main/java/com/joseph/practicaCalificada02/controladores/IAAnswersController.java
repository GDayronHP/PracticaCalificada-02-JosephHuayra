package com.joseph.practicaCalificada02.controladores;

import com.joseph.practicaCalificada02.modelos.entidades.IAAnswers;
import com.joseph.practicaCalificada02.servicios.IAAnswersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("iaAnswers")
public class IAAnswersController {

    @Autowired
    IAAnswersService iaAnswersService;

    @RequestMapping(value = "/listarIAAnswers", method = RequestMethod.GET)
    public String listarIAAnswers(Model model) {
        model.addAttribute("iaAnswers", iaAnswersService.listar());
        return "listarIAAnswers";
    }

    @RequestMapping(value = "/formIAAnswers")
    public String crearIAAnswers(Map<String, Object> model) {
        IAAnswers iaAnswers = new IAAnswers();
        model.put("iaAnswers", iaAnswers);
        return "formIAAnswers";
    }

    @RequestMapping(value = "/formIAAnswers", method = RequestMethod.POST)
    public String guardarIAAnswers(@Valid IAAnswers iaAnswers, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "formIAAnswers";
        }

        iaAnswersService.grabar(iaAnswers);
        status.setComplete();
        return "redirect:listarIAAnswers";
    }

    // Form para editar
    @RequestMapping(value="/formIAAnswers/{id}")
    public String editarIAAnswers(@PathVariable(value="id") Integer id, Map<String, Object> model) {
        IAAnswers iaAnswers = null;

        if(id > 0) {
            iaAnswers = iaAnswersService.buscar(id);
        } else {
            return "redirect:/listarIAAnswers";
        }
        model.put("iaAnswers", iaAnswers);
        return "formIAAnswers";
    }

    // Eliminar
    @RequestMapping(value = "/eliminarIAAnswers/{id}") // Modified mapping
    public String eliminarIAAnswer(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            iaAnswersService.eliminar(id);
        }
        return "redirect:/listarIAAnswers";
    }

    // Ver
    @RequestMapping(value = "/verIAAnswers")
    public String verIAAnswer(Model model) {
        model.addAttribute("iaAnswers", iaAnswersService.listar()); // Asegúrate de que esta lista no sea null
        model.addAttribute("titulo", "Lista de iaAnswers");
        return "iaAnswers/verIAAnswers"; // Asegúrate de que esta vista exista
    }

}