package api_restaurante.repository.impl;

import api_restaurante.dto.ClienteDto;
import api_restaurante.entity.QClienteEntity;
import api_restaurante.entity.QRestauranteEntity;
import api_restaurante.repository.ClienteRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QClienteEntity cliente = QClienteEntity.clienteEntity;
    final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;

    @Override
    public Page<ClienteDto> getAllByRestauranteId(Pageable pageable, Long restauranteId) {
        var query = new JPAQuery<ClienteDto>(em);

        query.select(Projections.constructor(ClienteDto.class, cliente))
                .from(restaurante)
                .innerJoin(restaurante.clientes, cliente)
                .where(restaurante.id.eq(restauranteId));

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    @Override
    public Page<ClienteDto> getClientesByRestauranteIdOrderByValorGasto(Pageable pageable, Long restauranteId) {
        var query = new JPAQuery<ClienteDto>(em);

        query.select(Projections.constructor(ClienteDto.class, cliente)).distinct()
                .from(restaurante)
                .innerJoin(restaurante.clientes, cliente)
                .where(restaurante.id.eq(restauranteId))
                .orderBy(cliente.qtdValorGasto.desc());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    @Override
    public Page<ClienteDto> getClientesComSeuMaiorPedido(Pageable pageable, Long restauranteId) {
        var query = new JPAQuery<ClienteDto>(em);

        //TODO: Terminar
        return null;
    }
}
