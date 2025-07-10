package es.usc.gestion.dto;

import lombok.Data;

@Data
public class AgregarArticuloPedidoDTO {
    private Long pedidoId;
    private Long articuloId;
    private Integer cantidad;
}
