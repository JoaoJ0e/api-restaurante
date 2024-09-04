package api_restaurante.controller;

import api_restaurante.dto.RestauranteDto;
import api_restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    //TODO: TESTAR

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/add")
    public RestauranteDto addRestaurante(@RequestBody RestauranteDto dto) {
        return restauranteService.addRestaurante(dto);
    }

    @PutMapping("/update/{id}")
    public RestauranteDto updRestaurante(@PathVariable Long id, @RequestBody RestauranteDto dto) {
        return restauranteService.updRestaurante(id, dto);
    }

    @GetMapping
    public List<RestauranteDto> getAllRestaurantes() {
        return restauranteService.getAllRestaurantes();
    }

    @GetMapping("/{id}")
    public RestauranteDto getRestauranteById(@PathVariable Long id) {
        return restauranteService.getRestauranteById(id);
    }
}
