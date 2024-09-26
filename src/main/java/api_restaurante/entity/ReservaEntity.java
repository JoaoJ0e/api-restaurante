package api_restaurante.entity;

import api_restaurante.dto.ReservaDto;
import api_restaurante.enums.StatusReservaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataReserva;

    @Column(nullable = false)
    private Integer qtdPessoas;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private StatusReservaEnum statusReservaEnum;

    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "mesa_id", nullable = false)
    private MesaEntity mesa;

    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private List<PedidoEntity> pedidos;

    public ReservaEntity(ReservaDto dto, ClienteEntity cliente, MesaEntity mesa) {
        this.id = dto.getId();
        this.dataReserva = dto.getDataReserva();
        this.qtdPessoas = dto.getQtdPessoas();
        this.statusReservaEnum = Optional.ofNullable(dto.getStatusReservaEnum()).isPresent() ? dto.getStatusReservaEnum() : StatusReservaEnum.AGENDADA;
        this.observacao = dto.getObservacao();
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public ReservaEntity atualizaStatusReserva(StatusReservaEnum statusNovo) {
        this.statusReservaEnum = statusNovo;

        return this;
    }
}
