package api_restaurante.service.impl;

import api_restaurante.dto.FuncionarioDto;
import api_restaurante.entity.FuncionarioEntity;
import api_restaurante.entity.RestauranteEntity;
import api_restaurante.exceptions.IdNotFoundException;
import api_restaurante.repository.FuncionarioRepository;
import api_restaurante.service.FuncionarioService;
import api_restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private RestauranteService restauranteService;
    @Override
    public FuncionarioDto addFuncionario(FuncionarioDto dto) {

        RestauranteEntity restauranteEntity = new RestauranteEntity(restauranteService.getRestauranteById(dto.getRestauranteId()));

        FuncionarioEntity FuncionarioEntity = new FuncionarioEntity(dto, restauranteEntity);
        return new FuncionarioDto(funcionarioRepository.save(FuncionarioEntity));
    }

    @Override
    public FuncionarioDto updFuncionario(Long id, FuncionarioDto FuncionarioAtualizado) {
        FuncionarioEntity FuncionarioEntity = findFuncionarioById(id);

        FuncionarioEntity.atualizaFuncionario(FuncionarioAtualizado);
        FuncionarioEntity entidadePersistida = funcionarioRepository.save(FuncionarioEntity);
        return new FuncionarioDto(entidadePersistida);
    }

    @Override
    public List<FuncionarioDto> getAllFuncionarios(Long restauranteId) {
        return funcionarioRepository.findAllByRestauranteId(restauranteId).stream().map(FuncionarioDto::new).toList();
    }

    @Override
    public FuncionarioDto getFuncionarioById(Long id) {
        return new FuncionarioDto(findFuncionarioById(id));
    }

    private FuncionarioEntity findFuncionarioById(Long id){
        Optional<FuncionarioEntity> FuncionarioEntity = funcionarioRepository.findById(id);

        if (FuncionarioEntity.isEmpty()) {
            throw new IdNotFoundException("Funcionario não encontrado com o ID fornecido");
        }

        return FuncionarioEntity.get();
    }
}
