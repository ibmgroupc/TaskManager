package com.ibm.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.entity.CreateUser;

public interface CreateUserRepository extends MongoRepository<CreateUser, String> {

	List<CreateUser> findByUsernameIgnoreCase(String username);

	List<CreateUser> findByUsernameAndPassword(String userName, String userPassword);

}
