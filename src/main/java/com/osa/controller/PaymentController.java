package com.osa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.CardDTO;
import com.osa.dto.PaymentDTO;
import com.osa.service.PaymentServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Payment ", description = "Payment")
@RequestMapping(value = "/payment")
public class PaymentController {


	 @Autowired
	 private PaymentServiceImpl paymentService;


		 /*
	     
	     Input :
	            {
	             "paymentId": 0,
	             "type": "PREPAID",
	             "status": "SUCCESSFUL",
	             "card": {
	               "id": 0,
	               "cardName": "CreditCard",
	               "cardNumber": "1235632612789122",
	               "expiryDate": "2025-11-14",
	               "bankName": "ICICI"
	}
	}   */
	
	 /**  
	  *  URL : http://localhost:8085/payment/add
	  *  @PostMapping maps HTTP POST request on addPayment Handler method 
	  *  Handler method handles HTTP POST request to add a new payment
	  *  The endpoint is "/add".
	  *  @param PaymentDTO paymentDTO which is a paymentDTO type
	  *  @return ResponseEntity with an PaymentDTO and an appropriate HTTP status code
	  */
	 
	 @PostMapping("/add")
	public ResponseEntity<Object> addPayment(@RequestBody PaymentDTO paymentDTO) {
		ResponseEntity<Object> response=null;
		PaymentDTO p= paymentService.addPayment(paymentDTO);
		response = new ResponseEntity<Object>(p,HttpStatus.CREATED);
		return response;
	}
	 
	 /**
      * URL : http://localhost:8085/payment/remove/1
      * @DeleteMapping maps HTTP POST request on removePayment Handler method 
      * Handler method handles HTTP DELETE requests to delete a payment
      * The endpoint is "/remove/{id}",, where {id} is a path variable representing the payment_id
      * @return ResponseEntity with a message and an appropriate HTTP status code
      */
	 
    @DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removePayment(@PathVariable long id) {
		paymentService.removePayment(id);
		return new ResponseEntity<String>("Payment with ID: "+id+" deleted successfully",HttpStatus.OK);
	}
	
    /**
     * URL : http://localhost:8085/payment/update/1
     * @PutMapping maps HTTP POST request on updatePayment Handler method 
     * Handler method handles HTTP PUT requests to update a payment
     * The endpoint is "/update/{id}", where {id} is a path variable representing the payment_id
     * @param PaymentDTO paymentDTO which is a paymentDTO type
     * @return ResponseEntity with a PaymentDTO and an appropriate HTTP status code
     */ 
    
	@PutMapping("/update/{id}")
	public ResponseEntity<PaymentDTO> updatePayment(@PathVariable long id, @Valid @RequestBody PaymentDTO paymentDTO) {
		
		return new ResponseEntity<PaymentDTO>(paymentService.updatePayment(id, paymentDTO), HttpStatus.OK);
	}
	




	
	
}
