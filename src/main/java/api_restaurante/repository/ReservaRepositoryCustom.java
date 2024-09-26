package api_restaurante.repository;

import api_restaurante.dto.ReservaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservaRepositoryCustom {
    Page<ReservaDto> getByRestauranteId(Pageable pageable, Long restauranteId);
}
