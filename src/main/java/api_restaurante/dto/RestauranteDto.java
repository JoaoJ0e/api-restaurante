package api_restaurante.dto;

import api_restaurante.entity.RestauranteEntity;
import api_restaurante.enums.TipoComidaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RestauranteDto {
    private Long id;
    private String nome;
    private String cnpj;
    private Integer qtdEstrelasMichelin;
    private TipoComidaEnum tipoComidaEnum;

    public RestauranteDto(RestauranteEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cnpj = entity.getCnpj();
        this.qtdEstrelasMichelin = entity.getQtdEstrelasMichelin();
        this.tipoComidaEnum = entity.getTipoComidaEnum();
    }

}
