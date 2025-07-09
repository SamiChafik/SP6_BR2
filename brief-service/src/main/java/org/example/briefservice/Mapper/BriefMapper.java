package org.example.briefservice.Mapper;


import org.example.briefservice.Dto.BriefDto;
import org.example.briefservice.Entity.Brief;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BriefMapper {

    BriefDto toDto(Brief brief);
    Brief toEntity(BriefDto dto);
}
