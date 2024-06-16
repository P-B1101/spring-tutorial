package com.b1101.property_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.b1101.property_management.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    boolean existsByUsername(String username);

    UserEntity findUserByUsernameAndPassword(String username, String password);
}
