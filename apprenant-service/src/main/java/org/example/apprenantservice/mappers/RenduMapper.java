package org.example.apprenantservice.mappers;

import org.example.apprenantservice.dtos.RenduDTO;
import org.example.apprenantservice.entities.Rendu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RenduMapper {

    Rendu toEntity(RenduDTO renduDto);
    RenduDTO toDTO(Rendu rendu);
    List<RenduDTO> toDTOs(List<Rendu> rendus);

}
