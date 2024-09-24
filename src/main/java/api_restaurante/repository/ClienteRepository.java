package api_restaurante.repository;

import api_restaurante.dto.ClienteDto;
import api_restaurante.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>, ClienteRepositoryCustom {
    List<ClienteEntity> findAllByRestauranteId(Long restauranteId);

    Page<ClienteEntity> findTopClientesByRestauranteIdAndQtdTotalGasto(Long restauranteId);

}
