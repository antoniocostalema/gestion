package es.usc.gestion.service;

import es.usc.gestion.model.Articulo;
import es.usc.gestion.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> obtenerPorId(Long id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo guardar(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public void eliminar(Long id) {
        articuloRepository.deleteById(id);
    }
}
