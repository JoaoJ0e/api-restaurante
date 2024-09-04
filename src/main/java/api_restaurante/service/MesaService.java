package api_restaurante.service;

import api_restaurante.dto.MesaDto;

import java.util.List;

public interface MesaService {

    MesaDto addMesa(MesaDto dto);
    MesaDto updMesa(Long id, MesaDto dto);
    List<MesaDto> getAllMesas();
    MesaDto getMesaById(Long id);
    
}
