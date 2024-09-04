package api_restaurante.service;

import api_restaurante.dto.ReservaDto;
import api_restaurante.enums.StatusReservaEnum;

import java.util.List;

public interface ReservaService {

    ReservaDto addReserva(ReservaDto dto);
    ReservaDto updStatusReserva(Long id, StatusReservaEnum statusNovo);
    List<ReservaDto> getAllReservas();
    ReservaDto getReservaById(Long id);
}
