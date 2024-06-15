package com.b1101.property_management.converter;

import org.springframework.stereotype.Component;

import com.b1101.property_management.entity.UserEntity;
import com.b1101.property_management.model.UserDto;

@Component
public class UserConverter {

    public UserEntity convert(UserDto dto) {
        final UserEntity entity = new UserEntity();
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setUsername(dto.getUsername());
        return entity;
    }

    public UserDto convert(UserEntity entity) {
        final UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setUsername(entity.getUsername());
        return dto;
    }
}
