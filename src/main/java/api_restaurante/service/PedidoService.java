package api_restaurante.service;

import api_restaurante.dto.PedidoDto;

import java.util.List;

public interface PedidoService {

    PedidoDto addPedido(PedidoDto dto, Long reservaId);

    List<PedidoDto> getAllPedidos(Long reservaId);

    PedidoDto getPedidoById(Long id);
}
