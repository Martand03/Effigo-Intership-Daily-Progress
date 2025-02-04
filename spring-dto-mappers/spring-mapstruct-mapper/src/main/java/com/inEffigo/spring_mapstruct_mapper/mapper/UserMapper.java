package com.inEffigo.spring_mapstruct_mapper.mapper;

import com.inEffigo.spring_mapstruct_mapper.dto.UserDto;
import com.inEffigo.spring_mapstruct_mapper.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "emailAddress")
    UserDto mapToUserDto(User user);

    @Mapping(source = "emailAddress", target = "email")
    User mapToUser(UserDto userDto);
}
