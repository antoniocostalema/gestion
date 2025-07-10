package es.usc.gestion.service;

import es.usc.gestion.model.PedidoArticulo;
import es.usc.gestion.repository.PedidoArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoArticuloServiceImpl implements PedidoArticuloService {

    private final PedidoArticuloRepository pedidoArticuloRepository;

    @Autowired
    public PedidoArticuloServiceImpl(PedidoArticuloRepository pedidoArticuloRepository) {
        this.pedidoArticuloRepository = pedidoArticuloRepository;
    }

    @Override
    public List<PedidoArticulo> obtenerTodos() {
        return pedidoArticuloRepository.findAll();
    }

    @Override
    public Optional<PedidoArticulo> obtenerPorId(Long id) {
        return pedidoArticuloRepository.findById(id);
    }

    @Override
    public PedidoArticulo guardar(PedidoArticulo pedidoArticulo) {
        return pedidoArticuloRepository.save(pedidoArticulo);
    }

    @Override
    public void eliminar(Long id) {
        pedidoArticuloRepository.deleteById(id);
    }
}
