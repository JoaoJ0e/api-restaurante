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
    private BigDecimal qtdValorGasto;
    private Boolean flgBloqueado;
    private Long restauranteId;

    public ClienteDto(ClienteEntity entity) {
        this.id = entity.getId();
        this.dataCadastro = entity.getDataCadastro();
        this.qtdReservas = entity.getQtdReservas();
        this.qtdValorGasto = entity.getQtdValorGasto();
        this.flgBloqueado = entity.getFlgBloqueado();
        this.restauranteId = entity.getRestaurante().getId();

        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.cpf = entity.getCpf();
        this.dataNascimento = entity.getDataNascimento();
        this.sexoEnum = entity.getSexoEnum();
        this.telefone = entity.getTelefone();
    }

}
