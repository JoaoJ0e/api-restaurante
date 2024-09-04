package api_restaurante.entity;

import api_restaurante.dto.RestauranteDto;
import api_restaurante.enums.TipoComidaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "restaurante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    private Integer qtdEstrelasMichelin;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoComidaEnum tipoComidaEnum;

    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<MesaEntity> mesas;

    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<FuncionarioEntity> funcionarios;

    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<ClienteEntity> clientes;

    public RestauranteEntity(RestauranteDto dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.cnpj = dto.getCnpj();
        this.qtdEstrelasMichelin = dto.getQtdEstrelasMichelin();
        this.tipoComidaEnum = dto.getTipoComidaEnum();
    }

    public RestauranteEntity atualizaRestaurante(RestauranteDto restauranteAtualizado) {
        this.nome = restauranteAtualizado.getNome();
        this.cnpj = restauranteAtualizado.getCnpj();
        this.qtdEstrelasMichelin = restauranteAtualizado.getQtdEstrelasMichelin();
        this.tipoComidaEnum = restauranteAtualizado.getTipoComidaEnum();

        return this;
    }

}
