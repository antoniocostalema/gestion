package es.usc.gestion.repository;

import es.usc.gestion.model.PedidoArticulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoArticuloRepository extends JpaRepository<PedidoArticulo, Long> {
}
