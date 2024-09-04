package api_restaurante.entity;

import api_restaurante.dto.PedidoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "reserva_id", nullable = false)
    private ReservaEntity reserva;

    public PedidoEntity(PedidoDto dto, ReservaEntity reserva) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.valor = dto.getValor();
        this.reserva = reserva;
    }


}
