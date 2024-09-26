package api_restaurante.repository;

import api_restaurante.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAllByRestauranteId(Long restauranteId);

    @Query("SELECT c " +
            "FROM ClienteEntity c " +
            "WHERE c.restaurante.id = :restauranteId " +
            "ORDER BY c.qtdTotalGasto DESC")
    List<ClienteEntity> findTopClientesByRestauranteIdAndQtdTotalGasto(Long restauranteId);

}
