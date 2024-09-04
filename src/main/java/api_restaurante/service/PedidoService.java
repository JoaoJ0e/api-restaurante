package api_restaurante.service;

import api_restaurante.dto.PedidoDto;

import java.util.List;

public interface PedidoService {

    PedidoDto addPedido(PedidoDto dto);
    List<PedidoDto> getAllPedidos();
    PedidoDto getPedidoById(Long id);
}
