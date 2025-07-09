package org.example.competanceservice.mappers;

import org.example.competanceservice.dtos.CompetenceDTO;
import org.example.competanceservice.entities.Competence;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMapper{
    Competence toEntity(CompetenceDTO dto);
    CompetenceDTO toDTO(Competence competence);
    List<CompetenceDTO> toDTOs(List<Competence> competenceList);
}
