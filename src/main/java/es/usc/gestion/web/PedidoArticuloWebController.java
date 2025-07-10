package es.usc.gestion.web;

import es.usc.gestion.model.Articulo;
import es.usc.gestion.model.Pedido;
import es.usc.gestion.model.PedidoArticulo;
import es.usc.gestion.service.ArticuloService;
import es.usc.gestion.service.PedidoArticuloService;
import es.usc.gestion.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/pedido-articulos")
public class PedidoArticuloWebController {

    @Autowired
    private PedidoArticuloService pedidoArticuloService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/nuevo")
    public String nuevo(@RequestParam Long pedidoId, Model model) {
        PedidoArticulo linea = new PedidoArticulo();
        Optional<Pedido> pedido = pedidoService.obtenerPorId(pedidoId);
        if (pedido.isPresent()) {
            linea.setPedido(pedido.get());
            model.addAttribute("linea", linea);
            model.addAttribute("articulos", articuloService.obtenerTodos());
            return "pedidos/lineaPedido";
        }
        return "redirect:/pedidos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoArticulo linea) {
        pedidoArticuloService.guardar(linea);
        return "redirect:/pedidos/" + linea.getPedido().getId();
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<PedidoArticulo> linea = pedidoArticuloService.obtenerPorId(id);
        if (linea.isPresent()) {
            model.addAttribute("linea", linea.get());
            model.addAttribute("articulos", articuloService.obtenerTodos());
            return "pedidos/lineaPedido";
        }
        return "redirect:/pedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Optional<PedidoArticulo> linea = pedidoArticuloService.obtenerPorId(id);
        if (linea.isPresent()) {
            Long pedidoId = linea.get().getPedido().getId();
            pedidoArticuloService.eliminar(id);
            return "redirect:/pedidos/" + pedidoId;
        }
        return "redirect:/pedidos";
    }
}
