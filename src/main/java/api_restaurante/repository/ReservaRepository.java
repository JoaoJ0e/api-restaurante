package api_restaurante.repository;

import api_restaurante.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long>, ReservaRepositoryCustom {
}
