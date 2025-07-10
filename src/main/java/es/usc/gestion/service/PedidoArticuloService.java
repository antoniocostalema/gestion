package es.usc.gestion.service;

import es.usc.gestion.model.PedidoArticulo;

import java.util.List;
import java.util.Optional;

public interface PedidoArticuloService {
    List<PedidoArticulo> obtenerTodos();
    Optional<PedidoArticulo> obtenerPorId(Long id);
    PedidoArticulo guardar(PedidoArticulo pedidoArticulo);
    void eliminar(Long id);
}
