package es.usc.gestion.service;

import es.usc.gestion.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> obtenerTodos();
    Optional<Pedido> obtenerPorId(Long id);
    Pedido guardar(Pedido pedido);
    void eliminar(Long id);
}

