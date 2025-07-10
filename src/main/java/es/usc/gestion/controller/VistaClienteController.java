package es.usc.gestion.controller;
import es.usc.gestion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "clientes/lista";
    }
}
