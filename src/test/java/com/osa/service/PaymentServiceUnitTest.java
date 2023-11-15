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
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.osa.dto.CardDTO;
import com.osa.dto.PaymentDTO;
import com.osa.exception.PaymentNotFoundException;
import com.osa.model.Appointment;
import com.osa.model.Card;
import com.osa.model.Payment;
import com.osa.repository.AppointmentRepository;
import com.osa.repository.CardRepository;
import com.osa.repository.IPaymentRepository;
import com.osa.service.PaymentServiceImpl;

@SpringBootTest
public class PaymentServiceUnitTest {

    @Mock
    private IPaymentRepository paymentRepository;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private Payment payment;
    private PaymentDTO paymentDTO;
    private Card card;

    @BeforeEach
    public void setUp() {
        // Initialize sample Payment and PaymentDTO
        payment = new Payment();
        payment.setPaymentId(1L);
//        payment.setAmount(100.0);

        paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(1L);
//        paymentDTO.setAmount(100.0);

        // Initialize sample Card
        card = new Card();
        card.setId(1L);
        card.setCardNumber("1234567890123456");
        card.setCardName("John Doe");
        card.setBankName("ICICI");
    }

//    @Test
//    public void testAddPayment() {
//        // Mocking the necessary methods
//        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
//        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(new Appointment()));
//        when(cardRepository.save(any(Card.class))).thenReturn(card);
//
//        PaymentDTO result = paymentService.addPayment(paymentDTO);
//
//        assertNotNull(result);
//        assertEquals(paymentDTO.getPaymentId(), result.getPaymentId());
//    }

    @Test
    public void testRemovePayment() {
        long id = 1L;

        when(paymentRepository.existsById(id)).thenReturn(true);
        when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));

        PaymentDTO result = paymentService.removePayment(id);

        assertNotNull(result);
        assertEquals(paymentDTO.getPaymentId(), result.getPaymentId());
    }

    @Test
    public void testRemovePayment_NotFound() {
        long id = 1L;

        when(paymentRepository.existsById(id)).thenReturn(false);

        assertThrows(PaymentNotFoundException.class, () -> paymentService.removePayment(id));
    }

    @Test
    public void testUpdatePayment() {
        long id = 1L;

        when(paymentRepository.existsById(id)).thenReturn(true);
        when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentDTO result = paymentService.updatePayment(id, paymentDTO);

        assertNotNull(result);
        assertEquals(paymentDTO.getPaymentId(), result.getPaymentId());
    }

    @Test
    public void testGetPaymentDetails_NotFound() {
        long id = 1L;

        when(paymentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(PaymentNotFoundException.class, () -> paymentService.getPaymentDetails(id));
    }

    @Test
    public void testGetAllPaymentDetails() {
        List<Payment> payments = new ArrayList<>();
        payments.add(payment);

        when(paymentRepository.findAll()).thenReturn(payments);

        List<PaymentDTO> result = paymentService.getAllPaymentDetails();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(paymentDTO.getPaymentId(), result.get(0).getPaymentId());
    }
    
}
