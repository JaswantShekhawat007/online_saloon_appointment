package com.osa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.service.AppointmentService;
import com.osa.service.CustomerService;
import com.osa.service.PaymentServiceImpl;
import com.osa.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Admin Service API", description = "Online Saloon Appointment")
@RequestMapping(value="/customer")
public class AdminController {
	
	//Customer Module
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//Appointment Service
	private AppointmentService appointmentService;
	
	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	//Payment Service
	private PaymentServiceImpl paymentService;

    @Autowired
    public void setPaymentService(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }
    
    //User Service
    private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
