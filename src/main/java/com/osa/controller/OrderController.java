package com.osa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.dto.OrderDTO;
import com.osa.exception.OrderNotFoundException;
import com.osa.service.IOrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
<<<<<<< HEAD
@Tag(name= "Order Controller", description= "Order Service API's")
=======
@Tag(name= "Order Service API", description= "Online Order Appointment")
>>>>>>> 2845cb1dc5a94995c9b0e89081c61302729671fd
@RequestMapping(value = "/order")
public class OrderController {
	
	private IOrderService orderService;
	
	@Autowired
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(value= "/add")
	public ResponseEntity<OrderDTO> addOrder(@Valid @RequestBody OrderDTO orderDTO){
		return new ResponseEntity<OrderDTO>(orderService.addOrder(orderDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value= "/delete/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable Long id) throws OrderNotFoundException{
		orderService.removeOrder(id);
		return new ResponseEntity<String>("Order with ID: "+id+" is successfully deleted.", HttpStatus.OK);
	}
	
	@PostMapping(value= "/update/{id}")
	public ResponseEntity<OrderDTO> updateOder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) throws OrderNotFoundException{
		return new ResponseEntity<OrderDTO>(orderService.updateOrder(id,orderDTO), HttpStatus.OK);
	}
	

}
