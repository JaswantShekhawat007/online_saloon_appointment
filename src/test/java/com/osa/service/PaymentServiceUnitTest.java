//package com.osa.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.BeanUtils;
//
//import com.osa.dto.PaymentDTO;
//import com.osa.exception.PaymentNotFoundException;
//import com.osa.model.Appointment;
//import com.osa.model.Card;
//import com.osa.model.Payment;
//import com.osa.repository.AppointmentRepository;
//import com.osa.repository.CardRepository;
//import com.osa.repository.IPaymentRepository;
//
//@ExtendWith(MockitoExtension.class)
//public class PaymentServiceUnitTest {
//
//    @Mock
//    private IPaymentRepository paymentRepository;
//
//    @Mock
//    private AppointmentRepository appointmentRepository;
//
//    @Mock
//    private CardRepository cardRepository;
//
//    @InjectMocks
//    private PaymentServiceImpl paymentService;
//
//    private PaymentDTO samplePaymentDTO;
//    private Payment samplePayment;
//
//    @BeforeEach
//    public void setUp() {
//        // Initialize sample data
//        samplePaymentDTO = new PaymentDTO();
//        samplePaymentDTO.setPaymentId(1L);
////        samplePaymentDTO.setAmount(100.0);
//        // Set other properties for samplePaymentDTO
//
//        samplePayment = new Payment();
//        samplePayment.setPaymentId(1L);
//        samplePayment.setAppointmentId(105L);
////        samplePayment.setStatus();
////        samplePayment.setAmount(100.0);
//        // Set other properties for samplePayment
//    }
//
//    @Test
//    public void testAddPayment() {
//        when(paymentRepository.save(any())).thenReturn(samplePayment);
//        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(new Appointment()));
//        when(cardRepository.save(any())).thenReturn(new Card());
//
//        PaymentDTO result = paymentService.addPayment(samplePaymentDTO);
//
//        assertNotNull(result);
//        assertEquals(samplePaymentDTO.getAppointmentId(), result.getId());
//        // Add more assertions for other properties
//    }
//
//    @Test
//    public void testRemovePayment() {
//        when(paymentRepository.existsById(anyLong())).thenReturn(true);
//        when(paymentRepository.findById(anyLong())).thenReturn(Optional.of(samplePayment));
//
//        PaymentDTO result = paymentService.removePayment(1L);
//
//        assertNotNull(result);
//        assertEquals(samplePaymentDTO.getId(), result.getId());
//        // Add more assertions for other properties
//    }
//
//    @Test
//    public void testUpdatePayment() {
//        when(paymentRepository.existsById(anyLong())).thenReturn(true);
//        when(paymentRepository.findById(anyLong())).thenReturn(Optional.of(samplePayment));
//        when(paymentRepository.save(any())).thenReturn(samplePayment);
//
//        PaymentDTO result = paymentService.updatePayment(1L, samplePaymentDTO);
//
//        assertNotNull(result);
//        assertEquals(samplePaymentDTO.getId(), result.getId());
//        // Add more assertions for other properties
//    }
//
//    @Test
//    public void testGetPaymentDetails() {
//        when(paymentRepository.findById(anyLong())).thenReturn(Optional.of(samplePayment));
//
//        PaymentDTO result = paymentService.getPaymentDetails(1L);
//
//        assertNotNull(result);
//        assertEquals(samplePaymentDTO.getId(), result.getId());
//        // Add more assertions for other properties
//    }
//
//    @Test
//    public void testGetAllPaymentDetails() {
//        List<Payment> payments = new ArrayList<>();
//        payments.add(samplePayment);
//        when(paymentRepository.findAll()).thenReturn(payments);
//
//        List<PaymentDTO> result = paymentService.getAllPaymentDetails();
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals(samplePaymentDTO.getId(), result.get(0).getId());
//        // Add more assertions for other properties
//    }
//}
//
