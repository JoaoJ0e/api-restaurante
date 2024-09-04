package api_restaurante.controller;

import api_restaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;
}
