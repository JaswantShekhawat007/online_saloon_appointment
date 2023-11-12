package com.osa.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.CustomerDTO;
import com.osa.dto.UserDTO;
import com.osa.exception.InvalidDataException;
import com.osa.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Online Saloon Appointment", description = "User Service API's")
@RequestMapping(value="/user")
public class UserController {
	
	private UserService userService;
	
<<<<<<< HEAD
=======
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/sign-in")
	public ResponseEntity<UserDTO> registerCustomer(@Valid @RequestBody UserDTO userDTO/*, BindingResult result*/) {
//		if (result.hasErrors()) {
//			throw new InvalidDataException("Customer data is not Valid!");
//		}
//		HttpSession session = request.get
		return new ResponseEntity<UserDTO>(userService.signIn(userDTO), HttpStatus.CREATED);
	}
	
>>>>>>> 11b30382d7b2839bb6aa1de7c87316e9f016c4d0
}
