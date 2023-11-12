package com.osa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.model.User;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Online Saloon Appointment", description = "Online Saloon Appointment API's")
@RequestMapping(value="/user")
public class UserController {
	
	
}
