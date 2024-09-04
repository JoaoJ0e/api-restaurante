package api_restaurante.repository;

import api_restaurante.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
}
