package api_restaurante.service.impl;

import api_restaurante.dto.ClienteDto;
import api_restaurante.entity.ClienteEntity;
import api_restaurante.entity.RestauranteEntity;
import api_restaurante.exceptions.IdNotFoundException;
import api_restaurante.repository.ClienteRepository;
import api_restaurante.service.ClienteService;
import api_restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    //TODO: Implementar CRUD
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestauranteService restauranteService;

    @Override
    public ClienteDto addCliente(ClienteDto dto) {
        RestauranteEntity restauranteEntity = new RestauranteEntity(restauranteService.getRestauranteById(dto.getRestauranteId()));

        ClienteEntity clienteEntity = new ClienteEntity(dto, restauranteEntity);
        return new ClienteDto(clienteRepository.save(clienteEntity));
    }

    @Override
    public ClienteDto updCliente(Long id, ClienteDto clienteAtualizado) {
        ClienteEntity clienteEntity = findClienteById(id);

        clienteEntity.atualizaCliente(clienteAtualizado);
        ClienteEntity entidadePersistida = clienteRepository.save(clienteEntity);
        return new ClienteDto(entidadePersistida);
    }

    @Override
    public List<ClienteDto> getAllClientes(Long restauranteId) {
        return clienteRepository.findAllByRestauranteId(restauranteId).stream().map(ClienteDto::new).toList();
    }

    @Override
    public ClienteDto getClienteById(Long id) {
        return new ClienteDto(findClienteById(id));
    }

    private ClienteEntity findClienteById(Long id){
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);

        if (clienteEntity.isEmpty()) {
            throw new IdNotFoundException("Cliente não encontrado com o ID fornecido");
        }

        return clienteEntity.get();
    }
    
}
