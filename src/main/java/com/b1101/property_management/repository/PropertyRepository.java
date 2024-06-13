package com.b1101.property_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.b1101.property_management.entity.PropertyEntity;

public interface PropertyRepository extends CrudRepository<PropertyEntity, String> {

}
