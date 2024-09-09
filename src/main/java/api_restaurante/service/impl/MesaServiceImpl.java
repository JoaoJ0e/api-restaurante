package api_restaurante.service.impl;

import api_restaurante.dto.MesaDto;
import api_restaurante.entity.MesaEntity;
import api_restaurante.entity.RestauranteEntity;
import api_restaurante.exceptions.IdNotFoundException;
import api_restaurante.repository.MesaRepository;
import api_restaurante.service.MesaService;
import api_restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private RestauranteService restauranteService;

    @Override
    public MesaDto addMesa(MesaDto dto) {

        RestauranteEntity restauranteEntity = new RestauranteEntity(restauranteService
                .getRestauranteById(dto.getRestauranteId()));

        MesaEntity mesaEntity = new MesaEntity(dto, restauranteEntity);
        return new MesaDto(mesaRepository.save(mesaEntity));
    }

    @Override
    public MesaDto updMesa(Long id, MesaDto mesaAtualizado) {
        MesaEntity mesaEntity = findMesaById(id);

        mesaEntity.atualizaMesa(mesaAtualizado);
        MesaEntity entidadePersistida = mesaRepository.save(mesaEntity);
        return new MesaDto(entidadePersistida);
    }

    @Override
    public List<MesaDto> getAllMesas(Long restauranteId) { //TODO: fix this shit, for goodness sake
        return mesaRepository.findAllByRestauranteId(restauranteId).stream().map(MesaDto::new).toList();
    }

    @Override
    public MesaDto getMesaById(Long id) {
        return new MesaDto(findMesaById(id));
    }

    private MesaEntity findMesaById(Long id){
        Optional<MesaEntity> mesaEntity = mesaRepository.findById(id);

        if (mesaEntity.isEmpty()) {
            throw new IdNotFoundException("Mesa não encontrado com o ID fornecido");
        }

        return mesaEntity.get();
    }
}
