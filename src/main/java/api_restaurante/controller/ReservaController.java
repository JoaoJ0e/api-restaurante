package api_restaurante.controller;

import api_restaurante.dto.ReservaDto;
import api_restaurante.entity.ReservaEntity;
import api_restaurante.enums.StatusReservaEnum;
import api_restaurante.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ReservaDto addReserva(@RequestBody ReservaDto dto) {
        return reservaService.addReserva(dto);
    }

    @PutMapping("/{id}/{statusNovo}")
    public ReservaDto updStatusReserva(@PathVariable("id") Long id, @PathVariable("statusNovo") StatusReservaEnum statusNovo) {
        return reservaService.updStatusReserva(id, statusNovo);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public Page<ReservaDto> getAllReservas(@PathVariable Long restauranteId,
                                           @RequestParam(defaultValue = "0", required = false) Integer page,
                                           @RequestParam(defaultValue = "1", required = false) Integer size
                                           ) {
        return reservaService.getAllReservas(Pageable.ofSize(size).withPage(page), restauranteId);
    }

    @GetMapping("/{id}")
    public ReservaDto getReservaById(@PathVariable Long id) {
        return reservaService.getReservaById(id);
    }

}
