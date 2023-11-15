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
@Tag(name= "Order Service API", description= "Online Order Appointment")
@RequestMapping(value = "/order")
public class OrderController {
	
	private IOrderService orderService;
	
	@Autowired
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	/**
	 * URL : http://localhost:8085/order/add
	 * @PostMapping maps HTTP POST request on addOrder Handler method
	 * Handles POST requests for adding an order 
	 * The end point is "/add"
	 * @param orderDTO which is a OrderDTO type
	 * @return ResponseEntity with an OrderDTO and an appropriate HTTP status code.
	 */
	
	@PostMapping(value= "/add")
	public ResponseEntity<OrderDTO> addOrder(@Valid @RequestBody OrderDTO orderDTO){
		return new ResponseEntity<OrderDTO>(orderService.addOrder(orderDTO), HttpStatus.CREATED);
	}
	
	/**
	 * URL : http://localhost:8085/order/delete/1
	 * @DeleteMapping maps HTTP DELETE requests on removeOrder method
	 * Handles DELETE requests for deleting an order 
	 * The end point is "/delete/{id}"
	 * @param  Long id that is a primary key of Order
	 * @return ResponseEntity with a meassage and an appropriate HTTP status code.
	*/
	
	@DeleteMapping(value= "/delete/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable Long id) throws OrderNotFoundException{
		orderService.removeOrder(id);
		return new ResponseEntity<String>("Order with ID: "+id+" is successfully deleted.", HttpStatus.OK);
	}
	
	/**
	 * URL : http://localhost:8085/order/update/1
	 * @PostMapping maps HTTP POST request on updateOrder Handler method
	 * Handles POST requests for updating an order 
	 * The end point is "/update/{id}"
	 * @param orderDTO which is a OrderDTO type and Long id that is primary key of Order
	 * @return ResponseEntity with an OrderDTO and an appropriate HTTP status code.
	 */
	
	@PostMapping(value= "/update/{id}")
	public ResponseEntity<OrderDTO> updateOder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) throws OrderNotFoundException{
		return new ResponseEntity<OrderDTO>(orderService.updateOrder(id,orderDTO), HttpStatus.OK);
	}
	

}
