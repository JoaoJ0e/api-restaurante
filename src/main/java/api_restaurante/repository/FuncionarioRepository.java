package api_restaurante.repository;

import api_restaurante.entity.ClienteEntity;
import api_restaurante.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
    List<FuncionarioEntity> findAllByRestauranteId(Long restauranteId);
}
