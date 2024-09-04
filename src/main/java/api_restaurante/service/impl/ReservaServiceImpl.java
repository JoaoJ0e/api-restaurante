package api_restaurante.service.impl;

import api_restaurante.dto.ReservaDto;
import api_restaurante.dto.RestauranteDto;
import api_restaurante.entity.ClienteEntity;
import api_restaurante.entity.ReservaEntity;
import api_restaurante.entity.RestauranteEntity;
import api_restaurante.enums.StatusReservaEnum;
import api_restaurante.exceptions.IdNotFoundException;
import api_restaurante.repository.ReservaRepository;
import api_restaurante.repository.RestauranteRepository;
import api_restaurante.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;


    //TODO: Implementar métodos getById em Cliente e Mesa, e depois terminar estes métodos
    @Override
    public ReservaDto addReserva(ReservaDto dto) {
        ReservaEntity reservaEntity = new ReservaEntity(dto);
        return new ReservaDto(reservaRepository.save(reservaEntity));
    }

    @Override
    public ReservaDto updStatusReserva(Long id, StatusReservaEnum statusNovo) {
        ReservaEntity reservaEntity = findReservaById(id);
        ReservaEntity entidadePersistida = reservaEntity.atualizaStatusReserva(statusNovo);
        return new ReservaDto(entidadePersistida);
    }

    @Override
    public List<ReservaDto> getAllReservas() {
        return reservaRepository.findAll().stream().map(ReservaDto::new).toList();
    }

    @Override
    public ReservaDto getReservaById(Long id) {
        return new ReservaDto(findReservaById(id));
    }

    private ReservaEntity findReservaById(Long id){
        Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id);

        if (reservaEntity.isEmpty()) {
            throw new IdNotFoundException("Reserva não encontrada com o ID fornecido");
        }

        return reservaEntity.get();
    }
}
