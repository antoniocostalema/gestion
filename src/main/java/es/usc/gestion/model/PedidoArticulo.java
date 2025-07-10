package es.usc.gestion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido_articulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    private Integer cantidad;
}

