package api_restaurante.dto;

import api_restaurante.entity.FuncionarioEntity;
import api_restaurante.enums.CargoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FuncionarioDto extends PessoaDto {
    private Long id;
    private CargoEnum cargoEnum;
    private LocalDate dataAdmissao;
    private BigDecimal salario;
    private BigDecimal cargaHoraria;
    private Long restauranteId;

    public FuncionarioDto(FuncionarioEntity entity) {
        this.id = entity.getId();
        this.cargoEnum = entity.getCargoEnum();
        this.dataAdmissao = entity.getDataAdmissao();
        this.cargaHoraria = entity.getCargaHoraria();
        this.restauranteId = entity.getRestaurante().getId();

        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.cpf = entity.getCpf();
        this.dataNascimento = entity.getDataNascimento();
        this.sexoEnum = entity.getSexoEnum();
        this.telefone = entity.getTelefone();
    }

}
