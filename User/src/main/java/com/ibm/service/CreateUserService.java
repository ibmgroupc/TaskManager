package com.ibm.service;

import java.util.List;
import java.util.Optional;

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
		String username=createUser.getUsername();
		List<CreateUser> oldCreateUser=createUserRepository.findAll();
		List<CreateUser> newCreateUser=createUserRepository.findByUsernameIgnoreCase(username);
		//if(create)
		if(newCreateUser.size()>=1)
		{
			throw new IllegalArgumentException("Username already exists");
		}
		if(!(createUser.getConfirmPassword().compareTo(createUser.getPassword())==0)){
			throw new IllegalArgumentException("Password does not Match");
		}
		createUserRepository.save(createUser);
		return createUser.getId();

	}
	
	public void updateUser(@Valid @RequestBody CreateUser createUser) {
		createUserRepository.save(createUser);		
	}
     
	
	public List<CreateUser> getUser(String username) {
	    return createUserRepository.findByUsernameIgnoreCase(username);	
	}

	public List<CreateUser> getUserByNameAndPassword(String userName, String userPassword) {
		return createUserRepository.findByUsernameAndPassword(userName,userPassword);
	}

	public List<CreateUser> getUser() {
		return createUserRepository.findAll();
	}

}
