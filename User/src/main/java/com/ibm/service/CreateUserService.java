package com.ibm.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.entity.CreateUser;
import com.ibm.repo.CreateUserRepository;

@Service
public class CreateUserService {
	@Autowired
	CreateUserRepository createUserRepository;

	public String createUser(@Valid CreateUser createUser) {
		createUserRepository.save(createUser);
		return createUser.getId();
	}

	public void updateUser(@Valid @RequestBody CreateUser createUser) {
		// TODO Auto-generated method stub
		createUserRepository.save(createUser);
		
	}

}
