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
	
	 /**  
     *  URL : http://localhost:8085/customer/register
     *  @PostMapping maps HTTP POST request on registerCustomer Handler method 
     *  Handler method handles HTTP POST request to register a new customer
     *  The endpoint is "/register".
     *  @param CustomerDTO customerDTO which is a CustomerDTO type
     *  @return ResponseEntity with a CustomerDTO and an appropriate HTTP status code
     */
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDTO> registerCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult result) throws InvalidDataException {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<CustomerDTO>(customerService.addCustomer(customerDTO), HttpStatus.CREATED);
	}
	
	
	
	 /**  
     *  URL : http://localhost:8085/customer/delete/1
     *  @DeleteMapping maps HTTP DELETE request on deleteCustomer Handler method 
     *  Handler method handles HTTP POST request to delete a customer
     *  The endpoint is "/delete/{id}".
     *  @return ResponseEntity with a message and an appropriate HTTP status code
     */
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
		customerService.removeCustomer(id);
		return new ResponseEntity<String>("Customer with ID: "+id+" deleted successfully",HttpStatus.OK);
	}
	
	
	
	 /**  
     *  URL : http://localhost:8085/customer/update/1
     *  @PutMapping maps HTTP POST request on updateCustomer Handler method 
     *  Handler method handles HTTP PUT request to update a customer
     *  The endpoint is "/update/{id}".
     *  @param CustomerDTO customerDTO which is a CustomerDTO type
     *  @return ResponseEntity with a CustomerDTO and an appropriate HTTP status code
     */
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerDTO customerDTO, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Customer data is not Valid!");
		}
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(id, customerDTO), HttpStatus.OK);
	}
	
}
