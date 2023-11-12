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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.AppointmentDTO;
import com.osa.service.AppointmentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Appointment Service APIs", description = "Online Saloon Appointment")
@RequestMapping(value="/appointment")
public class AppointmentController {
	
	private AppointmentService appointmentService;
	
	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/book-appointment")
	public ResponseEntity<AppointmentDTO> registerCustomer(@Valid @RequestBody AppointmentDTO appointmentDTO/*, BindingResult result*/) {
//		if (result.hasErrors()) {
//			throw new InvalidDataException("Customer data is not Valid!");
//		}
		return new ResponseEntity<AppointmentDTO>(appointmentService.addAppointment(appointmentDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete-appointment/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
		appointmentService.removeAppointment(id);
		return new ResponseEntity<String>("Customer with ID: "+id+" deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping("/update-appointment/{id}")
	public ResponseEntity<AppointmentDTO> updateCustomer(@PathVariable long id, @Valid @RequestBody AppointmentDTO appointmentDTO/*, BindingResult result*/) {
//		if (result.hasErrors()) {
//			throw new InvalidDataException("Customer data is not Valid!");
//		}
		return new ResponseEntity<AppointmentDTO>(appointmentService.updateAppointment(id, appointmentDTO), HttpStatus.OK);
	}
	
	@GetMapping("/get-appointment/{id}")
	public ResponseEntity<AppointmentDTO> getCustomerById(@PathVariable long id) {
		return new ResponseEntity<AppointmentDTO>(appointmentService.getAppointment(id), HttpStatus.OK);
	}
	
	@GetMapping("/get-appointment/all")
	public ResponseEntity<List<AppointmentDTO>> getAllCustomers() {
		return new ResponseEntity<List<AppointmentDTO>>(appointmentService.getAllAppointment(),HttpStatus.OK);
	}

}
