package api_restaurante.service;

import api_restaurante.dto.RestauranteDto;

import java.util.List;

public interface RestauranteService {

    RestauranteDto addRestaurante(RestauranteDto dto);
    RestauranteDto updRestaurante(Long id, RestauranteDto dto);
    List<RestauranteDto> getAllRestaurantes();
    RestauranteDto getRestauranteById(Long id);


}
