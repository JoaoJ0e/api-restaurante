package api_restaurante.service.impl;

import api_restaurante.repository.PedidoRepository;
import api_restaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
    //TODO: Implementar CRUD
    @Autowired
    private PedidoRepository pedidoRepository;
}
