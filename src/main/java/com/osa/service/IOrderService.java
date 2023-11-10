package com.osa.service;

import java.util.List;

import com.osa.dto.OrderDTO;
import com.osa.exception.OrderNotFoundException;

public interface IOrderService {
	OrderDTO addOrder(OrderDTO orderDTO);
	OrderDTO removeOrder(long id) throws OrderNotFoundException;
	OrderDTO updateOrder(long id, OrderDTO orderDTO) throws OrderNotFoundException;
	OrderDTO getOrderDetails(long id) throws OrderNotFoundException;
	List<OrderDTO> getAllOrders();
	
}
