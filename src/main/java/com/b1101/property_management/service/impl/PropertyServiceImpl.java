package com.b1101.property_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.b1101.property_management.converter.PropertyConverter;
import com.b1101.property_management.entity.PropertyEntity;
import com.b1101.property_management.model.PropertyDTO;
import com.b1101.property_management.repository.PropertyRepository;
import com.b1101.property_management.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO property) {
        final PropertyEntity result = propertyRepository.save(propertyConverter.convert(property));
        return propertyConverter.convert(result);
    }

    @Override
    public List<PropertyDTO> getAll() {
        final List<PropertyEntity> result = (List<PropertyEntity>) propertyRepository.findAll();
        final List<PropertyDTO> dtoList = new ArrayList<>();
        for (PropertyEntity entity : result) {
            dtoList.add(propertyConverter.convert(entity));
        }
        return dtoList;
    }

    @Override
    public PropertyDTO fullUpdateProperty(String id, PropertyDTO property) throws NotFoundException {
        final Optional<PropertyEntity> optionalProperty = propertyRepository.findById(id);
        if (!optionalProperty.isPresent()) {
            throw new NotFoundException();
        }
        PropertyEntity pe = propertyConverter.convert(property);
        pe.setId(id);
        pe = propertyRepository.save(pe);
        return propertyConverter.convert(pe);
    }

    @Override
    public PropertyDTO partialUpdateProperty(String id, PropertyDTO property) throws NotFoundException {
        final Optional<PropertyEntity> optionalProperty = propertyRepository.findById(id);
        if (!optionalProperty.isPresent()) {
            throw new NotFoundException();
        }
        PropertyEntity pe = optionalProperty.get();
        pe.setId(id);
        if (property.getTitle() != null)
            pe.setTitle(property.getTitle());
        if (property.getAddress() != null)
            pe.setAddress(property.getAddress());
        if (property.getDescription() != null)
            pe.setDescription(property.getDescription());
        if (property.getPrice() != null)
            pe.setPrice(property.getPrice());
        pe = propertyRepository.save(pe);
        return propertyConverter.convert(pe);
    }

    @Override
    public void deleteProperty(String id) throws NotFoundException {
        Optional<PropertyEntity> optionalProperty = propertyRepository.findById(id);
        if (!optionalProperty.isPresent()) {
            throw new NotFoundException();
        }
        propertyRepository.deleteById(id);
    }

}
