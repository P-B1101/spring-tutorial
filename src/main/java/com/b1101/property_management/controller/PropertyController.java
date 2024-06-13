package com.b1101.property_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b1101.property_management.model.PropertyDTO;
import com.b1101.property_management.service.PropertyService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("")
    public ResponseEntity<PropertyDTO> addPropertyDto(@RequestBody PropertyDTO property) {
        final PropertyDTO result = propertyService.saveProperty(property);
        return new ResponseEntity<PropertyDTO>(result, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PropertyDTO>> getAll() {
        List<PropertyDTO> result = propertyService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable String id, @RequestBody PropertyDTO dto) {
        PropertyDTO result;
        try {
            result = propertyService.fullUpdateProperty(id, dto);
            return new ResponseEntity<PropertyDTO>(result, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<PropertyDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PropertyDTO> partialyUpdateProperty(@PathVariable String id, @RequestBody PropertyDTO dto) {
        PropertyDTO result;
        try {
            result = propertyService.partialUpdateProperty(id, dto);
            return new ResponseEntity<PropertyDTO>(result, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<PropertyDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable String id) {

        try {
            propertyService.deleteProperty(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
