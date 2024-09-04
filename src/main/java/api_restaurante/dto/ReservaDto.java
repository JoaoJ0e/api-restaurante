package api_restaurante.dto;

import api_restaurante.entity.ReservaEntity;
import api_restaurante.enums.StatusReservaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservaDto {
    private Long id;
    private LocalDate dataReserva;
    private Integer qtdPessoas;
    private StatusReservaEnum statusReservaEnum;
    private String observacao;
    private Long clienteId;
    private Long mesaId;

    public ReservaDto(ReservaEntity entity) {
        this.id = entity.getId();
        this.dataReserva = entity.getDataReserva();
        this.qtdPessoas = entity.getQtdPessoas();
        this.statusReservaEnum = entity.getStatusReservaEnum();
        this.observacao = entity.getObservacao();
        this.clienteId = entity.getCliente().getId();
        this.mesaId = entity.getMesa().getId();
    }
}
