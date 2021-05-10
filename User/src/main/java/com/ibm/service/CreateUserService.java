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
		String username = createUser.getUsername();
		List<CreateUser> newCreateUser = createUserRepository.findByUsernameIgnoreCase(username);
		if (newCreateUser.size() >= 1) {
			throw new StatusIllegalArgumentException("Username already exists");
		}
		if (!(createUser.getConfirmPassword().compareTo(createUser.getPassword()) == 0)) {
			throw new StatusIllegalArgumentException("Password does not Match");
		}
		CreateUser savedUser = createUserRepository.save(createUser);
		return savedUser.getId();

	}

	public void updateUser(@Valid @RequestBody CreateUser createUser) {
		createUserRepository.save(createUser);
	}

	public List<CreateUser> getUser(String username) {
		return createUserRepository.findByUsernameIgnoreCase(username);
	}

	public List<CreateUser> getUserByNameAndPassword(String userName, String userPassword) {
		return createUserRepository.findByUsernameAndPassword(userName, userPassword);
	}

	public List<CreateUser> getUser() {
		return createUserRepository.findAll();
	}

	public void setCreateUserRepository(CreateUserRepository createUserRepository) {
		this.createUserRepository = createUserRepository;
	}

	public CreateUserRepository getCreateUserRepository() {
		return createUserRepository;
	}

	public Optional<CreateUser> getUserById(String userId) {
		return createUserRepository.findById(userId);
	}

}
