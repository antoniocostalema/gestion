package es.usc.gestion.controller;

import es.usc.gestion.model.Articulo;
import es.usc.gestion.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public List<Articulo> obtenerTodos() {
        return articuloService.obtenerTodos();
    }

    @PostMapping
    public Articulo crear(@RequestBody Articulo articulo) {
        return articuloService.guardar(articulo);
    }

    @GetMapping("/{id}")
    public Articulo obtenerPorId(@PathVariable Long id) {
        return articuloService.obtenerPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        articuloService.eliminar(id);
    }
}
