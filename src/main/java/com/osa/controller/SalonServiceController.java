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
import com.osa.exception.InvalidDataException;
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
	
	/**
	 * URL : http://localhost:8085/salonservice/add-service
	 * @PostMapping maps HTTP POST request on addSalonService Handler method
	 * Handles POST requests for adding salon service
	 * The end point is "/add-service/{id}"
	 * @param UserDTO userDTO and long id 
	 * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code.
	 */
	
	@PostMapping("/add-service")
	public ResponseEntity<SalonServiceDTO> addSalonService(@Valid @RequestBody SalonServiceDTO serviceDTO) {
		if(serviceDTO.getServiceId() == 0) {
			throw new InvalidDataException("No data provided");
		}
		return new ResponseEntity<SalonServiceDTO>(salonservice.addService(serviceDTO), HttpStatus.CREATED);
	}
	
	/**
	 * URL : http://localhost:8085/salonservice/delete/1
	 * @DeleteMapping maps HTTP DELETE request on deleteSalonService Handler method
	 * Handles DELETE requests for deleting salon service
	 * The end point is "/delete/{id}"
	 * @param long id 
	 * @return ResponseEntity with a message and an appropriate HTTP status code.
	 */
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSalonService(@PathVariable long id) {
		salonservice.removeService(id);
		return new ResponseEntity<String>("SalonService with ID: "+id+" deleted successfully",HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/salonservice/udate/1
	 *@PutMapping maps HTTP PUT request on updateSalonService Handler method
	 * Handles PUT requests for updating salon service
	 * The end point is "/update/{id}"
	 * @param SalonServiceDTO serviceDTO and long id 
	 * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code.
	 */
	
	@PutMapping("/update/{id}")
	public ResponseEntity<SalonServiceDTO> updateSalonService(@PathVariable long id, @Valid @RequestBody SalonServiceDTO serviceDTO/*, BindingResult result*/) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.updateService(id, serviceDTO), HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/salonservice/getbyid/1
	 * @GetMapping maps HTTP GET request on getSalonService Handler method
	 * Handles GET requests for getting salon service
	 * The end point is "/get/{id}"
	 * @param long id 
	 * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code.
	 */
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<SalonServiceDTO> getServiceById(@PathVariable long id) {
		return new ResponseEntity<SalonServiceDTO>(salonservice.getService(id), HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/salonservice/get/all
	 * @GetMapping maps HTTP GET request on getAllServices Handler method
	 * Handles GET requests for getting all salon service
	 * The end point is "/get/all"
	 * @param is not required
	 * @return ResponseEntity with List<SalonServiceDTO> and an appropriate HTTP status code.
	 */
	
	@GetMapping("/get/all")
	public ResponseEntity<List<SalonServiceDTO>> getAllServices() {
		return new ResponseEntity<List<SalonServiceDTO>>(salonservice.getAllServices(),HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/salonservice/getbyname/HAIRCUT
	 * @GetMapping maps HTTP GET request on getSalonService Handler method
	 * Handles GET requests for getting salon service
	 * The end point is "/getbyname/{name}"
	 * @param String SrviceName
	 * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code.
	 */
	
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<List<SalonServiceDTO>> getServiceByName(@PathVariable String name) {
		return new ResponseEntity<List<SalonServiceDTO>>(salonservice.getServicesByName(name), HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/salonservice/getbyprice/200
	 * @GetMapping maps HTTP GET request on getSalonService Handler method
	 * Handles GET requests for getting salon service
	 * The end point is "/getbyprice/{price}"
	 * @param String price
	 * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code.
	 */
	
	@GetMapping("/getbyprice/{price}")
	public ResponseEntity<List<SalonServiceDTO>> getServiceByPrice(@PathVariable String price) {
		return new ResponseEntity<List<SalonServiceDTO>>(salonservice.getServicesByPrice(price), HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/salonservice/getbyduration/1 hour
	 * @GetMapping maps HTTP GET request on getSalonService Handler method
	 * Handles GET requests for getting salon service
	 * The end point is "/getbyduration/{duration}"
	 * @param String duration 
	 * @return ResponseEntity with an SalonServiceDTO and an appropriate HTTP status code.
	 */
	
	@GetMapping("/getbyduration/{duration}")
	public ResponseEntity<List<SalonServiceDTO>> getServiceByDuration(@PathVariable String duration) {
		return new ResponseEntity<List<SalonServiceDTO>>(salonservice.getServicesByDuration(duration), HttpStatus.OK);
	}

}