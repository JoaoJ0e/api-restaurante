package api_restaurante.entity;

import api_restaurante.enums.CargoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "funcionario")
public class FuncionarioEntity extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    //TODO: construtor DTO
}
