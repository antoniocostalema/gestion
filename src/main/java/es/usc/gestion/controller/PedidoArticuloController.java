package es.usc.gestion.controller;

import es.usc.gestion.dto.AgregarArticuloPedidoDTO;
import es.usc.gestion.model.Articulo;
import es.usc.gestion.model.Pedido;
import es.usc.gestion.model.PedidoArticulo;
import es.usc.gestion.service.ArticuloService;
import es.usc.gestion.service.PedidoArticuloService;
import es.usc.gestion.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/pedido-articulos", 
            produces = "application/json; charset=UTF-8", 
            consumes = "application/json; charset=UTF-8")
public class PedidoArticuloController {

    @Autowired
    private PedidoArticuloService pedidoArticuloService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ArticuloService articuloService;

    // Crear
    @PostMapping
    public ResponseEntity<PedidoArticulo> agregarArticulo(@RequestBody AgregarArticuloPedidoDTO dto) {
        Optional<Pedido> pedidoOpt = pedidoService.obtenerPorId(dto.getPedidoId());
        Optional<Articulo> articuloOpt = articuloService.obtenerPorId(dto.getArticuloId());

        if (pedidoOpt.isEmpty() || articuloOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PedidoArticulo pedidoArticulo = new PedidoArticulo();
        pedidoArticulo.setPedido(pedidoOpt.get());
        pedidoArticulo.setArticulo(articuloOpt.get());
        pedidoArticulo.setCantidad(dto.getCantidad());

        return ResponseEntity.ok(pedidoArticuloService.guardar(pedidoArticulo));
    }

    // Leer todos
    @GetMapping
    public List<PedidoArticulo> obtenerTodos() {
        return pedidoArticuloService.obtenerTodos();
    }

    // Leer por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoArticulo> obtenerPorId(@PathVariable Long id) {
        return pedidoArticuloService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<PedidoArticulo> actualizar(@PathVariable Long id,
                                                     @RequestBody AgregarArticuloPedidoDTO dto) {
        Optional<PedidoArticulo> existente = pedidoArticuloService.obtenerPorId(id);
        Optional<Pedido> pedidoOpt = pedidoService.obtenerPorId(dto.getPedidoId());
        Optional<Articulo> articuloOpt = articuloService.obtenerPorId(dto.getArticuloId());

        if (existente.isEmpty() || pedidoOpt.isEmpty() || articuloOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PedidoArticulo pedidoArticulo = existente.get();
        pedidoArticulo.setPedido(pedidoOpt.get());
        pedidoArticulo.setArticulo(articuloOpt.get());
        pedidoArticulo.setCantidad(dto.getCantidad());

        return ResponseEntity.ok(pedidoArticuloService.guardar(pedidoArticulo));
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (pedidoArticuloService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pedidoArticuloService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
