package com.osa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.osa.dto.CustomerDTO;
import com.osa.dto.PaymentDTO;
import com.osa.exception.InvalidDataException;
import com.osa.model.Payment;
import com.osa.service.IPaymentService;
import com.osa.service.PaymentServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Payment Service API", description = "Online Saloon Appointment")
@RequestMapping(value = "/payment")
public class PaymentController {


    private PaymentServiceImpl paymentService;

    @Autowired
    public void setPaymentService(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }


    /*
        URL : http://localhost:8080/payment/addPayment
        Input :
               {
                 "paymentId":1
                 "type": "PREPAID",
                 "status":"successful",
                 "card_id":"23901",
                
               }
     */
    @PostMapping(value = "/addPayment")
    public ResponseEntity<PaymentDTO> addPayment(@Valid @RequestBody PaymentDTO paymentDTO, BindingResult result){
    	if (result.hasErrors()) {
			throw new InvalidDataException("Payment data is not Valid!");
        return new ResponseEntity<PaymentDTO>(paymentService.addPayment(paymentDTO), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/removePayment/{id}")
	public ResponseEntity<String> removePayment(@PathVariable long id) {
		paymentService.removePayment(id);
		return new ResponseEntity<String>("Payment with ID: "+id+" deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping("/updatePayment/{id}")
	public ResponseEntity<PaymentDTO> updatePayment(@PathVariable long id, @Valid @RequestBody PaymentDTO paymentDTO, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Payment data is not Valid!");
		
		return new ResponseEntity<PaymentDTO>(paymentService.updatePayment(id, paymentDTO), HttpStatus.OK);
	}
	
	@GetMapping("/getPayment/{id}")
	public ResponseEntity<PaymentDTO> getPaymentDetails(@PathVariable long id) {
		return new ResponseEntity<PaymentDTO>(paymentService.getPaymentDetails(id), HttpStatus.OK);
	}
	
	@GetMapping("/getPayments/all")
	public ResponseEntity<List<PaymentDTO>> getAllPaymentDetails() {
		return new ResponseEntity<List<PaymentDTO>>(paymentService.getAllPaymentDetails(),HttpStatus.OK);
	}



	
	
}
