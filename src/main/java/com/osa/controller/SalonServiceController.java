package com.osa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.SalonServiceDTO;
import com.osa.exception.InvalidDataException;
import com.osa.model.SalonService;
import com.osa.service.ISalonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Salon Service Service API", description = "Online Saloon Appointment")
@RequestMapping(value="/salonservice")
public class SalonServiceController {
	
	private ISalonService salonservice;

	@Autowired
	public void setSalonservice(ISalonService salonservice) {
		this.salonservice = salonservice;
	}
			
	
//  * URL : http://localhost:8085/salonservice/add
//  * Handles POST requests for adding a SalonService
//  * @param SalonServiceDTO which is a SalonServiceDTO type
//  * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code
		
	@PostMapping(value="/add")
	public ResponseEntity<SalonServiceDTO> addSalonService(@Valid @RequestBody SalonServiceDTO serviceDTO) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.addService(serviceDTO), HttpStatus.CREATED);
	}
	
//  * URL : http://localhost:8085/salonservice/delete/1
//  * Handles POST requests for deleting a SalonService by id
//  * @return ResponseEntity with a message and an appropriate HTTP status code
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteSalonService(@PathVariable long id) {
		salonservice.removeService(id);
		return new ResponseEntity<String>("SalonService with ID: "+id+" deleted successfully",HttpStatus.OK);
	}

//  * URL : http://localhost:8085/salonservice/update/1
//  * Handles PUT requests for updating a SalonService
//  * @param SalonServiceDTO which is a SalonServiceDTO type
//  * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<SalonServiceDTO> updateSalonService(@PathVariable long id, @Valid @RequestBody SalonServiceDTO serviceDTO/*, BindingResult result*/) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.updateService(id, serviceDTO), HttpStatus.OK);
	}

//  * URL : http://localhost:8085/salonservice/get/1
//  * Handles GET requests for retrieving a SalonService by id
//  * @param SalonServiceDTO which is a SalonServiceDTO type
//  * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code
	
	@GetMapping(value="/get/{id}")
	public ResponseEntity<SalonServiceDTO> getServiceById(@PathVariable long id) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.getService(id), HttpStatus.OK);
	}
	
	
//  * URL : http://localhost:8085/salonservice/getAll
//  * Handles GET requests for retrieving all SalonServices
//  * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code
	
	@GetMapping(value="/get/all")
	public ResponseEntity<List<SalonServiceDTO>> getAllServices() {
		return new ResponseEntity<List<SalonServiceDTO>>(salonservice.getAllServices(),HttpStatus.OK);
	}

}