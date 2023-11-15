package com.osa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.osa.dto.OrderDTO;
import com.osa.exception.OrderNotFoundException;
import com.osa.model.Customer;
import com.osa.model.Order;
import com.osa.model.Payment;
import com.osa.repository.CustomerRepository;
import com.osa.repository.IOrderRepository;
import com.osa.repository.IPaymentRepository;
import com.osa.service.OrderServiceImpl;

@SpringBootTest
public class OrderServiceUnitTest {

    @Mock
    private IOrderRepository orderRepository;

    @Mock
    private IPaymentRepository paymentRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private Order order;
    private OrderDTO orderDTO;

    @BeforeEach
    public void setUp() {
        // Initialize sample Order and OrderDTO
        order = new Order();
        order.setOrderId(1L);
        order.setAmount(100);
//        order.setPaymentMethod("CREDIT_CARD");
//        order.setOrderDescription("Sample order description");

        orderDTO = new OrderDTO();
        orderDTO.setOrderId(1L);
        orderDTO.setAmount(100);
//        orderDTO.setOrderDescription("Sample order description");
    }

    // Test cases for other methods

    @Test
    public void testAddOrder() {
        when(customerRepository.findById(orderDTO.getCustomer_userId())).thenReturn(Optional.of(new Customer()));
        when(paymentRepository.findById(orderDTO.getPayment_id())).thenReturn(Optional.of(new Payment()));

        OrderDTO result = orderService.addOrder(orderDTO);

        assertNotNull(result);
        assertEquals(orderDTO.getOrderId(), result.getOrderId());
    }


    @Test
    public void testUpdateOrder() {
        long id = 1L;
        when(orderRepository.existsById(id)).thenReturn(true);

        OrderDTO result = null;
		try {
			result = orderService.updateOrder(id, orderDTO);
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
		}

        assertNotNull(result);
        assertEquals(orderDTO.getOrderId(), result.getOrderId());
    }

    @Test
    public void testGetOrderDetails() {
        long id = 1L;
        when(orderRepository.findById(id)).thenReturn(Optional.of(order));

        OrderDTO result = null;
		try {
			result = orderService.getOrderDetails(id);
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
		}

        assertNotNull(result);
        assertEquals(orderDTO.getOrderId(), result.getOrderId());
    }

    @Test
    public void testGetOrderDetails_OrderNotFound() {
        long id = 1L;
        when(orderRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderDetails(id));
    }

    @Test
    public void testGetAllOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        when(orderRepository.findAll()).thenReturn(orders);

        List<OrderDTO> result = orderService.getAllOrders();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(orderDTO.getOrderId(), result.get(0).getOrderId());
    }
}

