package com.ibm.service;

import java.util.List;

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

	public List<CreateUser> getUser(String username) {
		// TODO Auto-generated method stub
	    return createUserRepository.findByUsernameIgnoreCase(username);	
	}

	public List<CreateUser> getUserByNameAndPassword(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return createUserRepository.findByUsernameAndPassword(userName,userPassword);
	}

}
