package com.osa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.AppointmentDTO;
import com.osa.dto.CustomerDTO;
import com.osa.dto.OrderDTO;
import com.osa.dto.PaymentDTO;
import com.osa.exception.OrderNotFoundException;
import com.osa.service.AppointmentService;
import com.osa.service.CustomerService;
import com.osa.service.IOrderService;
import com.osa.service.PaymentServiceImpl;
import com.osa.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Admin Service API", description = "Online Saloon Appointment")
@RequestMapping(value="/admini")
public class AdminController {
	
	/*
	 	* Providing Customer control to the Admin
	*/
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/get-customer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
		return new ResponseEntity<CustomerDTO>(customerService.getCustomer(id), HttpStatus.OK);
	}
	
	@GetMapping("/get-customer/all")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		return new ResponseEntity<List<CustomerDTO>>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	/*
	 * Appointment Admin Access 
	 */
	
	private AppointmentService appointmentService;
	
	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@GetMapping("/get-appointment/{id}")
	public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable long id) {
		return new ResponseEntity<AppointmentDTO>(appointmentService.getAppointment(id), HttpStatus.OK);
	}
	
	@GetMapping("/get-appointment/all")
	public ResponseEntity<List<AppointmentDTO>> getAllApointments() {
		return new ResponseEntity<List<AppointmentDTO>>(appointmentService.getAllAppointment(),HttpStatus.OK);
	}
	
	/*
	 * Order Admin Access 
	 */
	private IOrderService orderService;
	
	@Autowired
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping(value= "/get-service/{id}")
	public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable Long id) throws OrderNotFoundException{
		
		return new ResponseEntity<OrderDTO>(orderService.getOrderDetails(id), HttpStatus.OK);
	}
	
	@GetMapping(value= "/get-service/all")
	public ResponseEntity<List<OrderDTO>> getAllOrders(){
		return new ResponseEntity<List<OrderDTO>>(orderService.getAllOrders(), HttpStatus.OK);
	}
	
	/*
	 * Payment Admin Access 
	 */
    private PaymentServiceImpl paymentService;

    @Autowired
    public void setPaymentService(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }
    
	@GetMapping("/get-payment/{id}")
	public ResponseEntity<PaymentDTO> getPaymentDetails(@PathVariable long id) {
		return new ResponseEntity<PaymentDTO>(paymentService.getPaymentDetails(id), HttpStatus.OK);
	}
	
	@GetMapping("/get-payment/all")
	public ResponseEntity<List<PaymentDTO>> getAllPaymentDetails() {
		return new ResponseEntity<List<PaymentDTO>>(paymentService.getAllPaymentDetails(),HttpStatus.OK);
	}
	
}
