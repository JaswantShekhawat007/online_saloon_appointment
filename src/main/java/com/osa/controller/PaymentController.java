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

import com.osa.dto.CardDTO;
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


   

    @Autowired
   private PaymentServiceImpl paymentService;
    

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
    @PostMapping("/add")
	public ResponseEntity<Object> addPayment(@RequestBody PaymentDTO paymentDTO) {
		ResponseEntity<Object> response=null;
		PaymentDTO p= paymentService.addPayment(paymentDTO);
		response = new ResponseEntity<Object>(p,HttpStatus.CREATED);
		return response;
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
		}
		return new ResponseEntity<PaymentDTO>(paymentService.updatePayment(id, paymentDTO), HttpStatus.OK);
	}
	
<<<<<<< HEAD
	
	@GetMapping("/getPayment/{id}")
	public ResponseEntity<PaymentDTO> getPaymentDetails(@PathVariable long id) {
		return new ResponseEntity<PaymentDTO>(paymentService.getPaymentDetails(id), HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<Object> getAllPaymentDetails(){
		ResponseEntity<Object> response = null;
		List<PaymentDTO> lp= paymentService.getAllPaymentDetails();
		response=new ResponseEntity<Object>(lp,HttpStatus.OK);
		return response;
	}
=======

>>>>>>> 2845cb1dc5a94995c9b0e89081c61302729671fd



	
	
}
