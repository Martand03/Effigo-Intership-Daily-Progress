package com.inEffigo.spring_microservice_L2.service;

import com.inEffigo.dto.UserDto;
import com.inEffigo.spring_microservice_L2.entity.User;
import com.inEffigo.spring_microservice_L2.mapper.UserMapper;
import com.inEffigo.spring_microservice_L2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getUserById(Long id){
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not Found..."));
    }


    public String addUsers(List<UserDto> userDtos){
        List<User> users = userDtos.stream()
                .map(userMapper :: toEntity)
                .toList();

        userRepository.saveAll(users);

        return "Users added successfully...";
    }

}
