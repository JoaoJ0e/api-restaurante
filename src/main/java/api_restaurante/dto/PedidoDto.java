package api_restaurante.dto;

import api_restaurante.entity.PedidoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PedidoDto {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private Long reservaId;

    public PedidoDto(PedidoEntity entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.valor = entity.getValor();
        this.reservaId = entity.getReserva().getId();
    }

}

