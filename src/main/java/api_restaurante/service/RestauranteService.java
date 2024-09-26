package api_restaurante.service;

import api_restaurante.dto.RestauranteDto;
import api_restaurante.entity.RestauranteEntity;

import java.util.List;

public interface RestauranteService {

    RestauranteDto addRestaurante(RestauranteDto dto);
    RestauranteDto updRestaurante(Long id, RestauranteDto dto);
    List<RestauranteDto> getAllRestaurantes();
    RestauranteDto getRestauranteById(Long id);
    RestauranteEntity findRestauranteById(Long id);

}
