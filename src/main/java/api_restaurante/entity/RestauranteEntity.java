package api_restaurante.entity;

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


    //TODO: CRIAR CONSTRUTOR COM DTO

}
