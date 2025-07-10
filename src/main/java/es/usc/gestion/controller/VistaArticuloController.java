package es.usc.gestion.controller;

import es.usc.gestion.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/articulos")
    public String mostrarArticulos(Model model) {
        model.addAttribute("articulos", articuloService.obtenerTodos());
        return "articulos/lista";
    }
}

