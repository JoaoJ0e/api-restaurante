package api_restaurante.service;

import api_restaurante.dto.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    ClienteDto addCliente(ClienteDto dto);

    ClienteDto updCliente(Long id, ClienteDto dto);

    List<ClienteDto> getAllClientes(Long restauranteId);

    ClienteDto getClienteById(Long id);

    List<ClienteDto> getAllClientesOrderByQtdValorGasto(Long restauranteId);

    Page<ClienteDto> getClientesComSeuMaiorPedido(Pageable pageable, Long restauranteId);
}
