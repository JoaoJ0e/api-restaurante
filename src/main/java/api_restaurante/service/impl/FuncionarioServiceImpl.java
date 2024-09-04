package api_restaurante.service.impl;

import api_restaurante.repository.FuncionarioRepository;
import api_restaurante.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    //TODO: Implementar CRUD
    @Autowired
    private FuncionarioRepository funcionarioRepository;
}
