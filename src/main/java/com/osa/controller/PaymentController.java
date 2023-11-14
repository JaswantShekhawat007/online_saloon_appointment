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


import com.osa.dto.PaymentDTO;
import com.osa.service.PaymentServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Payment ", description = "Payment")
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
                 "type": "PREPAID",
                 "status":"successful",
                 "card_id":"23901",
                
               }
     */
    @PostMapping(value = "/addPayment")
    public ResponseEntity<PaymentDTO> addPayment(@Valid @RequestBody PaymentDTO paymentDTO){
        return new ResponseEntity<PaymentDTO>(paymentService.addPayment(paymentDTO), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removePayment(@PathVariable long id) {
		paymentService.removePayment(id);
		return new ResponseEntity<String>("Payment with ID: "+id+" deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PaymentDTO> updatePayment(@PathVariable long id, @Valid @RequestBody PaymentDTO paymentDTO) {
		
		return new ResponseEntity<PaymentDTO>(paymentService.updatePayment(id, paymentDTO), HttpStatus.OK);
	}
	




	
	
}
