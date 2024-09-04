package api_restaurante.dto;

import api_restaurante.entity.MesaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MesaDto {
    private Long id;
    private Integer numero;
    private Integer capacidadePessoas;
    private Long restauranteId;

    public MesaDto(MesaEntity entity) {
        this.id = entity.getId();
        this.numero = entity.getNumero();
        this.capacidadePessoas = entity.getCapacidadePessoas();
        this.restauranteId = entity.getRestaurante().getId();
    }
}
