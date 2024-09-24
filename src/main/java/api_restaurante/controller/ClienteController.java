package api_restaurante.controller;

import api_restaurante.dto.ClienteDto;
import api_restaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDto addCliente(@RequestBody ClienteDto dto) {
        return clienteService.addCliente(dto);
    }

    @PutMapping("/{id}")
    public ClienteDto updCliente(@PathVariable Long id, @RequestBody ClienteDto dto) {
        return clienteService.updCliente(id, dto);
    }

    @GetMapping("/{restauranteId}")
    public List<ClienteDto> getAllClientes(@PathVariable Long restauranteId) {
        return clienteService.getAllClientes(restauranteId);
    }

    @GetMapping("/{id}")
    public ClienteDto getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @GetMapping("/top")
    public List<ClienteDto> getAllClientesOrderByQtdValorGasto(Long restauranteId) {
        return clienteService.getAllClientesOrderByQtdValorGasto(restauranteId);
    }


}
