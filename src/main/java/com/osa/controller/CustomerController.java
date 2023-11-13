package com.osa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.CustomerDTO;
import com.osa.exception.InvalidDataException;
import com.osa.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Customer Service API", description = "Online Saloon Appointment")
@RequestMapping(value="/customer")
public class CustomerController {
	
	/*
	 * Customer Module access to customer 
	 */
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDTO> registerCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult result) throws InvalidDataException {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<CustomerDTO>(customerService.addCustomer(customerDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
		customerService.removeCustomer(id);
		return new ResponseEntity<String>("Customer with ID: "+id+" deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable long id, @Valid @RequestBody CustomerDTO customerDTO, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(id, customerDTO), HttpStatus.OK);
	}
	
}
