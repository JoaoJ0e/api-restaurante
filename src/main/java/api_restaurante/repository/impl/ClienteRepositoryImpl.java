package api_restaurante.repository.impl;

import api_restaurante.dto.ClienteDto;
import api_restaurante.repository.ClienteRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<ClienteDto> getClientesComSeuMaiorPedido(Pageable pageable, Long restauranteId) {

    }
}
