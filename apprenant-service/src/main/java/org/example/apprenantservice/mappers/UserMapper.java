package org.example.apprenantservice.mappers;



import org.example.apprenantservice.dtos.UserDTO;
import org.example.apprenantservice.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO dto);
    UserDTO toDTO(User user);
    List<UserDTO> toDTOs(List<User> users);
}
