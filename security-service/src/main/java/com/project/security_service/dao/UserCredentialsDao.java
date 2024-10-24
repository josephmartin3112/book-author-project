package com.project.security_service.dao;

import com.project.security_service.entity.UserCredentialsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsDao extends MongoRepository<UserCredentialsEntity, String>{
    public Optional<UserCredentialsEntity> findByName(String name);

}
