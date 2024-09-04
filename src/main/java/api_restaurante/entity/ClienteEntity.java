package api_restaurante.entity;

import api_restaurante.dto.ClienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cliente")
public class ClienteEntity extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    @Column(nullable = false)
    private Long qtdReservas;

    @Column(nullable = false)
    private BigDecimal qtdValorGasto;

    @Column(nullable = false)
    private Boolean flgBloqueado;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<ReservaEntity> reservas;
    
    public ClienteEntity(ClienteDto dto, RestauranteEntity restaurante) {
        this.id = dto.getId();
        this.dataCadastro = Objects.nonNull(dto.getDataCadastro()) ? dto.getDataCadastro() : LocalDate.now();
        this.qtdReservas = Objects.nonNull(dto.getQtdReservas()) ? dto.getQtdReservas() : 0;
        this.qtdValorGasto = Objects.nonNull(dto.getQtdValorGasto()) ? dto.getQtdValorGasto() : BigDecimal.valueOf(0);
        this.flgBloqueado = Objects.nonNull(dto.getFlgBloqueado()) ? dto.getFlgBloqueado() : false;
        this.restaurante = restaurante;

        this.nome = dto.getNome();
        this.sobrenome = dto.getSobrenome();
        this.cpf = dto.getCpf();
        this.dataNascimento = dto.getDataNascimento();
        this.sexoEnum = dto.getSexoEnum();
        this.telefone = dto.getTelefone();
    }
    
    public ClienteEntity atualizaCliente(ClienteDto clienteAtualizado) {
        this.nome = clienteAtualizado.getNome();
        this.sobrenome = clienteAtualizado.getSobrenome();
        this.dataNascimento = clienteAtualizado.getDataNascimento();
        this.sexoEnum = clienteAtualizado.getSexoEnum();
        this.telefone = clienteAtualizado.getTelefone();
        return this;
    }
}
