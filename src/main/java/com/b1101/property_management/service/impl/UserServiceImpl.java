package com.b1101.property_management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b1101.property_management.converter.UserConverter;
import com.b1101.property_management.entity.UserEntity;
import com.b1101.property_management.exceptions.UserAlreadyExistException;
import com.b1101.property_management.model.UserDto;
import com.b1101.property_management.repository.UserRepository;
import com.b1101.property_management.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDto> getAllUsers() {
        final List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        final List<UserDto> result = new ArrayList<UserDto>();
        for (UserEntity entity : users) {
            result.add(userConverter.convert(entity));
        }
        return result;

    }

    @Override
    public UserDto register(UserDto userDto) throws UserAlreadyExistException {
        final boolean isExist = userRepository.existsByUsername(userDto.getUsername());
        if (isExist)
            throw new UserAlreadyExistException();
        final UserEntity entity = userRepository.save(userConverter.convert(userDto));
        return userConverter.convert(entity);
    }

    @Override
    public UserDto login(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
