package com.osa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.UserDTO;
import com.osa.exception.InvalidDataException;
import com.osa.exception.UserNotFoundException;
import com.osa.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "User Service API", description = "Online Saloon Appointment")
@RequestMapping(value="/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * URL : http://localhost:8085/user/sign-in
	 * @PostMapping maps HTTP POST request on signIn Handler method
	 * Handles POST requests for signing in
	 * The end point is "/sign-in"
	 * @param UserDTO userDTO
	 * @return ResponseEntity with an UserDTO and an appropriate HTTP status code.
	 */
	
	@PostMapping("/sign-in")
	public ResponseEntity<UserDTO> signIn(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<UserDTO>(userService.signIn(userDTO), HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/user/Nandu
	 * @PostMapping maps HTTP POST request on changePassword Handler method
	 * Handles POST requests for changing password
	 * The end point is "/change-password/{id}"
	 * @param UserDTO userDTO and long id 
	 * @return ResponseEntity with an UserDTO and an appropriate HTTP status code.
	 */
	
	@PostMapping("/change-password/{id}")
	public ResponseEntity<UserDTO> changePassword(@Valid @RequestBody UserDTO userDTO, @PathVariable long id, BindingResult result) 
			throws UserNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<UserDTO>(userService.changePassword(id, userDTO), HttpStatus.OK);
		
	}
	
	

	
}
