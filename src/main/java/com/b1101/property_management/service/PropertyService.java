package com.b1101.property_management.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.b1101.property_management.model.PropertyDTO;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO property);

    List<PropertyDTO> getAll();

    PropertyDTO fullUpdateProperty(String id, PropertyDTO property) throws NotFoundException;

    PropertyDTO partialUpdateProperty(String id, PropertyDTO property) throws NotFoundException;

    void deleteProperty(String id) throws NotFoundException;
}
