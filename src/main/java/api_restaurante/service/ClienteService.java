package api_restaurante.service;

import api_restaurante.dto.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

    ClienteDto addCliente(ClienteDto dto);

    ClienteDto updCliente(Long id, ClienteDto dto);

    void deleteCliente(Long id);

    Page<ClienteDto> getAllClientes(Pageable pageable, Long restauranteId);

    ClienteDto getClienteById(Long id);

    Page<ClienteDto> getAllClientesOrderByQtdValorGasto(Pageable pageable, Long restauranteId);

    Page<ClienteDto> getClientesComSeuMaiorPedido(Pageable pageable, Long restauranteId);
}
