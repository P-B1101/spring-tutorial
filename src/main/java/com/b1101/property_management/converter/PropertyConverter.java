package com.b1101.property_management.converter;

import org.springframework.stereotype.Component;

import com.b1101.property_management.entity.PropertyEntity;
import com.b1101.property_management.model.PropertyDTO;

@Component
public class PropertyConverter {
    public PropertyEntity convert(
            PropertyDTO dto) {
        PropertyEntity entity = new PropertyEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAddress(dto.getAddress());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public PropertyDTO convert(
            PropertyEntity entity) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAddress(entity.getAddress());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        return dto;
    }

}
