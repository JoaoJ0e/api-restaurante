package api_restaurante.repository;

import api_restaurante.dto.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryCustom {

    Page<ClienteDto> getClientesByRestauranteIdOrderByValorGasto(Pageable pageable, Long restauranteId);
}
