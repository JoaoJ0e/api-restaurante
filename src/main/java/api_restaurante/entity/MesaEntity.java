package api_restaurante.entity;

import api_restaurante.dto.MesaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "mesa")
public class MesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer capacidadePessoas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    public MesaEntity(MesaDto dto, RestauranteEntity restaurante) {
        this.id = dto.getId();
        this.numero = dto.getNumero();
        this.capacidadePessoas = dto.getCapacidadePessoas();
        this.restaurante = restaurante;
    }

    public MesaEntity atualizaMesa(MesaDto mesaAtualizada) {
        this.numero = mesaAtualizada.getNumero();
        this.capacidadePessoas = mesaAtualizada.getCapacidadePessoas();

        return this;
    }
}
