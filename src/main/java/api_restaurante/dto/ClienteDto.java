package api_restaurante.dto;

import api_restaurante.entity.ClienteEntity;
import api_restaurante.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteDto extends PessoaDto {
    private Long id;
    private LocalDate dataCadastro;
    private Long qtdReservas;
    private BigDecimal qtd_valor_gasto;
    private Boolean flg_bloqueado;
    private Long restauranteId;

    public ClienteDto(ClienteEntity entity) {
        this.id = entity.getId();
        this.dataCadastro = entity.getDataCadastro();
        this.qtdReservas = entity.getQtdReservas();
        this.qtd_valor_gasto = entity.getQtd_valor_gasto();
        this.flg_bloqueado = entity.getFlg_bloqueado();
        this.restauranteId = entity.getRestaurante().getId();

        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.cpf = entity.getCpf();
        this.dataNascimento = entity.getDataNascimento();
        this.sexoEnum = entity.getSexoEnum();
        this.telefone = entity.getTelefone();
    }

}
