package api_restaurante.controller;

import api_restaurante.dto.ReservaDto;
import api_restaurante.entity.ReservaEntity;
import api_restaurante.enums.StatusReservaEnum;
import api_restaurante.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ReservaDto updStatusReserva(@PathVariable Long id, @RequestBody StatusReservaEnum statusNovo) {
        return reservaService.updStatusReserva(id, statusNovo);
    }

    @GetMapping
    public List<ReservaDto> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ReservaDto getReservaById(@PathVariable Long id) {
        return reservaService.getReservaById(id);
    }

}
