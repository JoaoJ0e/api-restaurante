package api_restaurante.service;

import api_restaurante.dto.FuncionarioDto;

import java.util.List;

public interface FuncionarioService {

    FuncionarioDto addFuncionario(FuncionarioDto dto);
    FuncionarioDto updFuncionario(Long id, FuncionarioDto dto);
    List<FuncionarioDto> getAllFuncionarios();
    FuncionarioDto getFuncionarioById(Long id);
}
