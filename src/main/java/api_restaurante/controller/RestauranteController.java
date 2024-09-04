package api_restaurante.controller;

import api_restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;
}
