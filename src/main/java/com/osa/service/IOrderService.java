package com.osa.service;

import java.util.List;

import com.osa.dto.OrderDTO;
import com.osa.exception.OrderNotFoundException;

public interface IOrderService {
	OrderDTO addOrder(OrderDTO orderDTO);
	Boolean removeOrder(Long id) throws OrderNotFoundException;
	OrderDTO updateOrder(Long id, OrderDTO orderDTO) throws OrderNotFoundException;
	OrderDTO getOrderDetails(Long id) throws OrderNotFoundException;
	List<OrderDTO> getAllOrders();
	
}
