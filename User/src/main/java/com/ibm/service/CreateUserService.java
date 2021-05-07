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
		//List<CreateUser> oldCreateUser1=createUserRepository.findByUsernameIgnoreCase(username);
		if(oldCreateUser.contains(username)) {
			throw new IllegalArgumentException("Username already exists");
		}
//		Optional<CreateUser> oldCreateUser=createUserRepository.findByUsernameIgnoreCase(createUser.getUsername());
//		oldCreateUser.ifPresent(oldcreateUser->{
//			String oldusername=oldcreateUser.getUsername();
//		});
		
//		if(oldCreateUser.contains(username)) {
//			throw new IllegalArgumentException("Username already exists");
//		}
//		else {
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

}
