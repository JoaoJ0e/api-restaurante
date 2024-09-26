package api_restaurante.service.impl;

import api_restaurante.dto.ClienteDto;
import api_restaurante.dto.ReservaDto;
import api_restaurante.entity.ClienteEntity;
import api_restaurante.entity.MesaEntity;
import api_restaurante.entity.ReservaEntity;
import api_restaurante.entity.RestauranteEntity;
import api_restaurante.enums.StatusReservaEnum;
import api_restaurante.exceptions.IdNotFoundException;
import api_restaurante.repository.ReservaRepository;
import api_restaurante.service.ClienteService;
import api_restaurante.service.MesaService;
import api_restaurante.service.ReservaService;
import api_restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MesaService mesaService;

    @Override
    public ReservaDto addReserva(ReservaDto dto) {

        ClienteDto clienteDto               = clienteService.getClienteById(dto.getClienteId());
        RestauranteEntity restauranteEntity = new RestauranteEntity(restauranteService.getRestauranteById(clienteDto.getRestauranteId()));
        ClienteEntity clienteEntity         = new ClienteEntity(clienteDto, restauranteEntity);
        MesaEntity mesaEntity               = new MesaEntity(mesaService.getMesaById(dto.getMesaId()), restauranteEntity);

        ReservaEntity reservaEntity = new ReservaEntity(dto, clienteEntity, mesaEntity);
        return new ReservaDto(reservaRepository.save(reservaEntity));
    }

    @Override
    public ReservaDto updStatusReserva(Long id, StatusReservaEnum statusNovo) {
        ReservaEntity reservaEntity = findReservaById(id);
        ReservaEntity entidadePersistida = reservaEntity.atualizaStatusReserva(statusNovo);
        return new ReservaDto(entidadePersistida);
    }

    @Override
    public Page<ReservaDto> getAllReservas(Pageable pageable, Long restauranteId) {
        return reservaRepository.getByRestauranteId(pageable, restauranteId);
    }

    @Override
    public ReservaDto getReservaById(Long id) {
        return new ReservaDto(findReservaById(id));
    }

    @Override
    public ReservaEntity getReservaEntityById(Long id) {
        return findReservaById(id);
    }

    private ReservaEntity findReservaById(Long id){
        Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id);

        if (reservaEntity.isEmpty()) {
            throw new IdNotFoundException("Reserva não encontrada com o ID fornecido");
        }

        return reservaEntity.get();
    }
}
