package es.usc.gestion.service;

import es.usc.gestion.model.Articulo;

import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    List<Articulo> obtenerTodos();
    Optional<Articulo> obtenerPorId(Long id);
    Articulo guardar(Articulo articulo);
    void eliminar(Long id);
}
