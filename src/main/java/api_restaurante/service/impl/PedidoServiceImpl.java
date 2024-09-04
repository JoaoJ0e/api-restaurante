package api_restaurante.service.impl;

import api_restaurante.dto.PedidoDto;
import api_restaurante.entity.*;
import api_restaurante.exceptions.IdNotFoundException;
import api_restaurante.repository.PedidoRepository;
import api_restaurante.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private ReservaService reservaService;


    @Override
    public PedidoDto addPedido(PedidoDto dto, Long reservaId) {
        ReservaEntity reservaEntity = reservaService.getReservaEntityById(reservaId);
        PedidoEntity PedidoEntity = new PedidoEntity(dto, reservaEntity);
        return new PedidoDto(pedidoRepository.save(PedidoEntity));
    }

    @Override
    public List<PedidoDto> getAllPedidos(Long reservaId) {
        return pedidoRepository.findAllByReservaId(reservaId).stream().map(PedidoDto::new).toList();
    }

    @Override
    public PedidoDto getPedidoById(Long id) {
        return new PedidoDto(findPedidoById(id));
    }

    private PedidoEntity findPedidoById(Long id){
        Optional<PedidoEntity> PedidoEntity = pedidoRepository.findById(id);

        if (PedidoEntity.isEmpty()) {
            throw new IdNotFoundException("Pedido não encontrado com o ID fornecido");
        }

        return PedidoEntity.get();
    }
}
