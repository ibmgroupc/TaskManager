package com.ibm.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.CreateUser;
import com.ibm.service.CreateUserService;

@RestController
public class CreateUserController {
	@Autowired
	CreateUserService createUserService;
	
Logger logger = Logger.getLogger(CreateUserController.class.getName());
    /**
     * 
     * @param createUser
     * @param bindingResult
     * @return
     */
	
	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createUser(@RequestBody @Valid CreateUser createUser, BindingResult bindingResult) {
		validateModel(bindingResult);
		return createUserService.createUser(createUser);
	}
	
	private void validateModel(BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went Wrong");
		}
	}
	
	/**
	 * 
	 * @param createUser
	 * @param createUserId
	 */
		
	@GetMapping("/user/{username}")
	List<CreateUser> getUser(@PathVariable("username") String username) {
		return createUserService.getUser(username);
	}
	
	@GetMapping("/user/{id}")
	Optional<CreateUser> getUserById(@PathVariable("id") String userId) {
		return createUserService.getUserById(userId);
	}
	
	@GetMapping("/user/search")
	List<CreateUser> getUserByNameAndPassword(@RequestParam("username") String userName,@RequestParam("password") String userPassword) {
		return createUserService.getUserByNameAndPassword(userName,userPassword);
	}
	
	@PutMapping("user/{id}")
	void updateUser(@RequestBody @Valid CreateUser createUser, @PathVariable("id") String createUserId) {
		logger.log(Level.INFO,createUserId);
		createUser.setId(createUserId);
		createUserService.updateUser(createUser);
	}
}
