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
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.SalonServiceDTO;
import com.osa.service.ISalonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Online Saloon Appointment", description = "Saloon Service Appointment API's")
@RequestMapping(value="/salonservice")
public class SalonServiceController {
	
	private ISalonService salonservice;

	@Autowired
	public void setSalonservice(ISalonService salonservice) {
		this.salonservice = salonservice;
	}

	@PostMapping("/add")
	public ResponseEntity<SalonServiceDTO> addSalonService(@Valid @RequestBody SalonServiceDTO serviceDTO/*, BindingResult result*/) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.addService(serviceDTO), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSalonService(@PathVariable long id) {
		salonservice.removeService(id);
		return new ResponseEntity<String>("SalonService with ID: "+id+" deleted successfully",HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<SalonServiceDTO> updateSalonService(@PathVariable long id, @Valid @RequestBody SalonServiceDTO serviceDTO/*, BindingResult result*/) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.updateService(id, serviceDTO), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<SalonServiceDTO> getServiceById(@PathVariable long id) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.getService(id), HttpStatus.OK);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<SalonServiceDTO>> getAllServices() {
		return new ResponseEntity<List<SalonServiceDTO>>(salonservice.getAllServices(),HttpStatus.OK);
	}

}