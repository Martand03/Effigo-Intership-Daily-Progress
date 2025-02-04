package com.inEffigo.spring_mapstruct_mapper.service;

import com.inEffigo.spring_mapstruct_mapper.dto.UserDto;
import com.inEffigo.spring_mapstruct_mapper.entity.User;
import com.inEffigo.spring_mapstruct_mapper.mapper.UserMapper;
import com.inEffigo.spring_mapstruct_mapper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDto createOrUpdateUser(UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::mapToUserDto)
                .toList();
    }

    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapToUserDto);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
