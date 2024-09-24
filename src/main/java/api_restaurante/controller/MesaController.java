package api_restaurante.controller;

import api_restaurante.dto.MesaDto;
import api_restaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @PostMapping
    public MesaDto addMesa(@RequestBody MesaDto dto) {
        return mesaService.addMesa(dto);
    }

    @PutMapping("/{id}")
    public MesaDto updMesa(@PathVariable Long id, @RequestBody MesaDto dto) {
        return mesaService.updMesa(id, dto);
    }

    @GetMapping
    public List<MesaDto> getAllMesas() {
        return mesaService.getAllMesas();
    }
    @GetMapping("/{id}")
    public MesaDto getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id);
    }

}
