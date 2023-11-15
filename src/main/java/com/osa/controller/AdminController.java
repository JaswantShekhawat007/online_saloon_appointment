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

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Admin Service API", description = "Online Saloon Appointment")
@RequestMapping(value="/admin")
public class AdminController {
	
	/*
	 	* Providing Customer control to the Admin
	*/
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	 /**  
     *  URL : http://localhost:8085/admin/get-customer/101
     *  @GetMapping maps HTTP GET request on getCustomerById Handler method 
     *  Handler method handles HTTP GET request to retrieve a customer by id
     *  The endpoint is "/get-customer/{id}",  where {id} is a path variable representing the id of customer
     *  @return ResponseEntity with a CustomerDTO and an appropriate HTTP status code
     */
	
	@GetMapping("/get-customer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
		return new ResponseEntity<CustomerDTO>(customerService.getCustomer(id), HttpStatus.OK);
	}
	
	 /**  
     *  URL : http://localhost:8085/admin/get-customer/all
     *  @GetMapping maps HTTP GET request on getAllCustomers Handler method 
     *  Handler method handles HTTP GET request to retrieve all customers
     *  The endpoint is "/get-customer/all"
     *  @return ResponseEntity with CustomerDTO and an appropriate HTTP status code
     */
	
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
	
	/**
     * URL : http://localhost:8085/admin/get-appointment/301
	 * @GetMapping maps HTTP GET request on getAppointmentById Handler method 
     * Handler method handles HTTP GET request to retrieve all appointments
     * The endpoint is "/get-appointment/{id}", where {id} is a path variable representing the id of appointment
     * @return ResponseEntity with a AppointmentDTO and an appropriate HTTP status code
     */
	
	@GetMapping("/get-appointment/{id}")
	public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable long id) {
		return new ResponseEntity<AppointmentDTO>(appointmentService.getAppointment(id), HttpStatus.OK);
	}
	
	/**
     * URL : http://localhost:8085/admin/"/get-appointment/all"
	 * @GetMapping maps HTTP GET request on getAllApointments Handler method 
     * Handler method handles HTTP GET request to retrieve an appointment by id
     * The endpoint is "/get-appointment/all"
     * @return ResponseEntity with a AppointmentDTO and an appropriate HTTP status code
     */
	
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
	
	/**
     * URL : http://localhost:8085/admin/get-orderservice/1
	 * @GetMapping maps HTTP GET request on getOrderDetails Handler method 
     * Handler method handles HTTP GET request to retrieve an order by id
     * The endpoint is "/get-orderservice/{id}", where {id} is a path variable representing the id of order
     * @return ResponseEntity with a OrderDTO and an appropriate HTTP status code
     */
	
	@GetMapping(value= "/get-service/{id}")
	public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable Long id) throws OrderNotFoundException{
		
		return new ResponseEntity<OrderDTO>(orderService.getOrderDetails(id), HttpStatus.OK);
	}
	
	/**
     * URL : http://localhost:8085/admin/get-orderservice/all
	 * @GetMapping maps HTTP GET request on getAllOrders Handler method 
     * Handler method handles HTTP GET request to retrieve all orders
     * The endpoint is "/get-orderservice/all"
     * @return ResponseEntity with a OrderDTO and an appropriate HTTP status code
     */
	
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
    
    /**
     * URL : http://localhost:8085/admin/get-payment/1
	 * @GetMapping maps HTTP GET request on getPaymentDetails Handler method 
     * Handler method handles HTTP GET request to retrieve a payment by id
     * The endpoint is "/get-payment/{id}", where {id} is a path variable representing the payment_id
     * @return ResponseEntity with a PaymentDTO and an appropriate HTTP status code
     */
    
	@GetMapping("/get-payment/{id}")
	public ResponseEntity<PaymentDTO> getPaymentDetails(@PathVariable long id) {
		return new ResponseEntity<PaymentDTO>(paymentService.getPaymentDetails(id), HttpStatus.OK);
	}
	
	/**
     * URL : http://localhost:8085/admin/get-payment/all
	 * @GetMapping maps HTTP GET request on getAllPaymentDetails Handler method 
     * Handler method handles HTTP GET request to retrieve all payments
     * The endpoint is "/get-payment/all"
     * @return ResponseEntity with a PaymentDTO and an appropriate HTTP status code
     */
	
	@GetMapping("/get-payment/all")
	public ResponseEntity<List<PaymentDTO>> getAllPaymentDetails(){
		ResponseEntity<List<PaymentDTO>> response = null;
		List<PaymentDTO> lp= paymentService.getAllPaymentDetails();
		response=new ResponseEntity<List<PaymentDTO>>(lp,HttpStatus.OK);
		return response;
	}
	
}
