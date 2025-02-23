package com.inEffigo.spring_microservice_L2.mapper;

import com.inEffigo.dto.UserDto;
import com.inEffigo.spring_microservice_L2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
