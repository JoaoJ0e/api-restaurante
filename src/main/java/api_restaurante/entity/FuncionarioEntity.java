package api_restaurante.entity;

import api_restaurante.dto.FuncionarioDto;
import api_restaurante.enums.CargoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "funcionario")
public class FuncionarioEntity extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private CargoEnum cargoEnum;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(nullable = false)
    private BigDecimal cargaHoraria;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    public FuncionarioEntity(FuncionarioDto dto, RestauranteEntity restaurante) {
        this.id = dto.getId();
        this.cargoEnum = dto.getCargoEnum();
        this.dataAdmissao = Objects.nonNull(dto.getDataAdmissao()) ? dto.getDataAdmissao() : LocalDate.now();
        this.cargaHoraria = dto.getCargaHoraria();
        this.restaurante = restaurante;

        this.nome = dto.getNome();
        this.sobrenome = dto.getSobrenome();
        this.cpf = dto.getCpf();
        this.dataNascimento = dto.getDataNascimento();
        this.sexoEnum = dto.getSexoEnum();
        this.telefone = dto.getTelefone();
    }

    public FuncionarioEntity atualizaFuncionario(FuncionarioDto funcionarioAtualizado) {
        this.cargoEnum = funcionarioAtualizado.getCargoEnum();
        this.cargaHoraria = funcionarioAtualizado.getCargaHoraria();

        this.nome = funcionarioAtualizado.getNome();
        this.sobrenome = funcionarioAtualizado.getSobrenome();
        this.telefone = funcionarioAtualizado.getTelefone();

        return this;
    }
}
