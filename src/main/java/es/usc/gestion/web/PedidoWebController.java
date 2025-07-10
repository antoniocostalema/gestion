package es.usc.gestion.web;

import es.usc.gestion.model.Cliente;
import es.usc.gestion.model.Pedido;
import es.usc.gestion.service.ClienteService;
import es.usc.gestion.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class PedidoWebController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        List<Pedido> pedidos = pedidoService.obtenerTodos();
        model.addAttribute("pedidos", pedidos);
        return "pedidos/pedidos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "pedidos/pedido";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pedido pedido) {
        if (pedido.getFecha() == null) {
            pedido.setFecha(LocalDate.now());
        }
        pedidoService.guardar(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Pedido> pedido = pedidoService.obtenerPorId(id);
        if (pedido.isPresent()) {
            model.addAttribute("pedido", pedido.get());
            model.addAttribute("clientes", clienteService.obtenerTodos());
            return "pedidos/pedido";
        }
        return "redirect:/pedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return "redirect:/pedidos";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Optional<Pedido> pedido = pedidoService.obtenerPorId(id);
        if (pedido.isPresent()) {
            model.addAttribute("pedido", pedido.get());
            return "pedidos/lineasPedido";
        }
        return "redirect:/pedidos";
    }
}
