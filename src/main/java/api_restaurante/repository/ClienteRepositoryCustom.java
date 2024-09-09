package api_restaurante.repository;

import api_restaurante.dto.ClienteDto;

import java.util.List;

public interface ClienteRepositoryCustom {

    List<ClienteDto> getClientesByRestauranteIdOrderByValorGasto(Long restauranteId);
}
