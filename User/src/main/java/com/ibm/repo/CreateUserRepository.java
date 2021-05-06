package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.entity.CreateUser;

public interface CreateUserRepository extends MongoRepository<CreateUser, String> {

}
