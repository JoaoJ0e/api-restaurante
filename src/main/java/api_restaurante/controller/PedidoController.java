package api_restaurante.controller;

import api_restaurante.dto.PedidoDto;
import api_restaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    // TODO: TESTAR TODOS OS CONTROLLERS
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/reserva/{reservaId}")
    public PedidoDto addPedido(@RequestBody PedidoDto dto, @PathVariable Long reservaId) {
        return pedidoService.addPedido(dto, reservaId);
    }

    @GetMapping("/reserva/{reservaId}")
    public List<PedidoDto> getAllPedidos(@PathVariable Long reservaId) {
        return pedidoService.getAllPedidos(reservaId);
    }

    @GetMapping("/{id}")
    public PedidoDto getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }
}
