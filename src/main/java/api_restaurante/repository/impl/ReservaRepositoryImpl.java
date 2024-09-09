package api_restaurante.repository.impl;

import api_restaurante.dto.ReservaDto;
import api_restaurante.entity.QReservaEntity;
import api_restaurante.repository.ReservaRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


public class ReservaRepositoryImpl implements ReservaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QReservaEntity reserva = QReservaEntity.reservaEntity;

    @Override
    public Page<ReservaDto> getByRestauranteId(Pageable pageable, Long restauranteId) {
        var query = new JPAQuery<ReservaDto>(em);

        query.select(Projections.constructor(ReservaDto.class, reserva)).distinct()
                .from(reserva)
                .where(reserva.mesa.restaurante.id.eq(restauranteId))
                .orderBy(reserva.dataReserva.asc());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount()) ;
    }
}
