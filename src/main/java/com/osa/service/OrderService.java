package com.osa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.OrderDTO;
import com.osa.exception.OrderNotFoundException;
import com.osa.model.Order;
import com.osa.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public OrderDTO addOrder(OrderDTO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		orderRepository.save(order);
		return orderDTO;
	}

	@Override
	public Boolean removeOrder(Long id) throws OrderNotFoundException {
	
		if(orderRepository.existsById(id)) {
			Order order = orderRepository.findById(id).get();
			orderRepository.delete(order);;
			return true;
		}
		throw new OrderNotFoundException("Enter valid order to be deleted.");
	}

	@Override
	public OrderDTO updateOrder(Long id, OrderDTO orderDTO) throws OrderNotFoundException {
		if(orderRepository.existsById(id)) {
			Order order = new Order();
			BeanUtils.copyProperties(orderDTO, order);
			orderRepository.save(order);
			return orderDTO;
		}
		throw new OrderNotFoundException("Enter a valid Order to be updated");
	}

	@Override
	public OrderDTO getOrderDetails(Long id) throws OrderNotFoundException {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		if(optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			OrderDTO orderDTO = new OrderDTO();
			BeanUtils.copyProperties(order, orderDTO);
			return orderDTO;
		}
		throw new OrderNotFoundException("Enter a valid Order Id to get order details.");
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		List<Order> orders = orderRepository.findAll();
		for(Order order :orders) {
			OrderDTO orderDTO = new OrderDTO();
			BeanUtils.copyProperties(order, orderDTO);
			orderDTOs.add(orderDTO);
		}
		return orderDTOs;
	}

}
