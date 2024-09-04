package api_restaurante.service.impl;

import api_restaurante.dto.RestauranteDto;
import api_restaurante.entity.RestauranteEntity;
import api_restaurante.exceptions.IdNotFoundException;
import api_restaurante.repository.RestauranteRepository;
import api_restaurante.service.ReservaService;
import api_restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public RestauranteDto addRestaurante(RestauranteDto dto) {
        RestauranteEntity restauranteEntity = new RestauranteEntity(dto);
        return new RestauranteDto(restauranteRepository.save(restauranteEntity));
    }

    @Override
    public RestauranteDto updRestaurante(Long id, RestauranteDto restauranteAtualizado) {
        RestauranteEntity restauranteEntity = findRestauranteById(id);

        restauranteEntity.atualizaRestaurante(restauranteAtualizado);
        RestauranteEntity entidadePersistida = restauranteRepository.save(restauranteEntity);
        return new RestauranteDto(entidadePersistida);
    }

    @Override
    public List<RestauranteDto> getAllRestaurantes() {
        return restauranteRepository.findAll().stream().map(RestauranteDto::new).toList();
    }

    @Override
    public RestauranteDto getRestauranteById(Long id) {
        return new RestauranteDto(findRestauranteById(id));
    }

    private RestauranteEntity findRestauranteById(Long id){
        Optional<RestauranteEntity> restauranteEntity = restauranteRepository.findById(id);

        if (restauranteEntity.isEmpty()) {
            throw new IdNotFoundException("Restaurante não encontrado com o ID fornecido");
        }

        return restauranteEntity.get();
    }
}
