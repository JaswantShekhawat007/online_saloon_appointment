package com.osa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import com.osa.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Online Saloon Appointment", description = "User Service API's")
@RequestMapping(value="/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/sign-in")
	public ResponseEntity<UserDTO> signIn(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<UserDTO>(userService.signIn(userDTO), HttpStatus.OK);
	}
	
	
	@PostMapping("/change-password/{id}")
	public ResponseEntity<UserDTO> changePassword(@Valid @RequestBody UserDTO userDTO, @PathVariable long id, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<UserDTO>(userService.changePassword(id, userDTO), HttpStatus.OK);
	}
	
	

	
}
