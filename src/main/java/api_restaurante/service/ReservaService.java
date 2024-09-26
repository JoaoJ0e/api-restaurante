package api_restaurante.service;

import api_restaurante.dto.ReservaDto;
import api_restaurante.entity.ReservaEntity;
import api_restaurante.enums.StatusReservaEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservaService {

    ReservaDto addReserva(ReservaDto dto);
    ReservaDto updStatusReserva(Long id, StatusReservaEnum statusNovo);
    Page<ReservaDto> getAllReservas(Pageable pageable, Long restauranteId);
    ReservaDto getReservaById(Long id);
    ReservaEntity getReservaEntityById(Long id);
}
