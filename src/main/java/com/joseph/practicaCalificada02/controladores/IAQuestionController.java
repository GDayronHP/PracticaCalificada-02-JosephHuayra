package com.joseph.practicaCalificada02.controladores;

import com.joseph.practicaCalificada02.modelos.entidades.IAQuestion;
import com.joseph.practicaCalificada02.modelos.entidades.IAQuestion;
import com.joseph.practicaCalificada02.servicios.IAQuestionService;
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
@SessionAttributes("iaQuestion")
public class IAQuestionController {

    @Autowired
    IAQuestionService iaQuestionService;

    @RequestMapping(value = "/listarIAQuestion", method = RequestMethod.GET)
    public String listarIAQuestion(Model model) {
        model.addAttribute("iaQuestions", iaQuestionService.listar());
        return "listarIAQuestion";
    }

    @RequestMapping(value = "/formIAQuestion")
    public String crearIAQuestion(Map<String, Object> model) {
        IAQuestion iaQuestion = new IAQuestion();
        model.put("iaQuestion", iaQuestion);
        return "formIAQuestion";
    }

    @RequestMapping(value = "/formIAQuestion", method = RequestMethod.POST)
    public String guardarIAQuestion(@Valid IAQuestion iaQuestion, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "formIAQuestion";
        }

        iaQuestionService.grabar(iaQuestion);
        status.setComplete();
        return "redirect:listarIAQuestion";
    }

    // Form para editar
    @RequestMapping(value="/formIAQuestion/{id}")
    public String editarIAQuestion(@PathVariable(value="id") Integer id, Map<String, Object> model) {
        IAQuestion iaQuestion = null;

        if(id > 0) {
            iaQuestion = iaQuestionService.buscar(id);
        } else {
            return "redirect:/listarIAQuestion";
        }
        model.put("iaQuestion", iaQuestion);
        return "formIAQuestion";
    }

    // Eliminar
    @RequestMapping(value = "/eliminarIAQuestion/{id}") // Modified mapping
    public String eliminarIAQuestion(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            iaQuestionService.eliminar(id);
        }
        return "redirect:/listarIAQuestion";
    }

    // Ver
    @RequestMapping(value = "/verIAQuestion")
    public String verIAQuestion(Model model) {
        model.addAttribute("iaQuestion", iaQuestionService.listar());
        model.addAttribute("titulo", "Lista de iaQuestions");
        return "iaQuestion/verIAQuestion";
    }

}