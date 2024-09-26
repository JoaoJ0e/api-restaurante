package api_restaurante.repository;

import api_restaurante.entity.ClienteEntity;
import api_restaurante.entity.MesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<MesaEntity, Long> {
    List<MesaEntity> findAllByRestauranteId(Long restauranteId);
}
