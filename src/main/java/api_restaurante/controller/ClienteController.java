package api_restaurante.controller;

import api_restaurante.dto.ClienteDto;
import api_restaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/restaurante/{restauranteId}")
    public Page<ClienteDto> getAllClientes(@PathVariable Long restauranteId,
                                           @RequestParam(defaultValue = "0", required = false) Integer page,
                                           @RequestParam(defaultValue = "1", required = false) Integer size
                                            ){
        return clienteService.getAllClientes(Pageable.ofSize(size).withPage(page),restauranteId);
    }

    @GetMapping("/{id}")
    public ClienteDto getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @GetMapping("/restaurante/{restauranteId}/top")
    public Page<ClienteDto> getAllClientesOrderByQtdValorGasto(@PathVariable Long restauranteId,
                                                               @RequestParam(defaultValue = "0", required = false) Integer page,
                                                               @RequestParam(defaultValue = "1", required = false) Integer size
                                                               ) {
        return clienteService.getAllClientesOrderByQtdValorGasto(Pageable.ofSize(size).withPage(page), restauranteId);
    }

}
