package api_restaurante.repository;

import api_restaurante.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAllByRestauranteId(Long restauranteId);
}
