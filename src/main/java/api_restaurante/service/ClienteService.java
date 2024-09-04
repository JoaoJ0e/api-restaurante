package api_restaurante.service;

import api_restaurante.dto.ClienteDto;

import java.util.List;

public interface ClienteService {

    ClienteDto addCliente(ClienteDto dto);
    ClienteDto updCliente(Long id, ClienteDto dto);
    List<ClienteDto> getAllClientes(Long restauranteId);
    ClienteDto getClienteById(Long id);
}
