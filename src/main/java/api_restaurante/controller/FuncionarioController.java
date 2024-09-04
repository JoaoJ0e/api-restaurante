package api_restaurante.controller;

import api_restaurante.dto.FuncionarioDto;
import api_restaurante.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public FuncionarioDto addFuncionario(FuncionarioDto dto) {
        return funcionarioService.addFuncionario(dto);
    }

    @PutMapping("/{id}")
    public FuncionarioDto updFuncionario(@PathVariable Long id, @RequestBody FuncionarioDto dto) {
        return funcionarioService.updFuncionario(id, dto);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<FuncionarioDto> getAllFuncionarios(@PathVariable Long restauranteId) {
        return funcionarioService.getAllFuncionarios(restauranteId);
    }

    @GetMapping("/{id}")
    public FuncionarioDto getFuncionarioById(@PathVariable Long id) {
        return funcionarioService.getFuncionarioById(id);
    }

}
