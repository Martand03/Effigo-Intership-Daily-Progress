package com.inEffigo.spring_microservice_L2.config;

import com.inEffigo.dto.UserDto;
import com.inEffigo.spring_microservice_L2.entity.User;
import com.inEffigo.spring_microservice_L2.mapper.UserMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProcessor implements ItemProcessor<UserDto, User> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User process(UserDto userDto){
        return userMapper.toEntity(userDto);
    }
}
