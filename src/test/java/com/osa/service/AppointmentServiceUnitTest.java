package com.osa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.osa.dto.AppointmentDTO;
import com.osa.model.Appointment;
import com.osa.model.Customer;
import com.osa.model.SalonService;
import com.osa.repository.AppointmentRepository;
import com.osa.repository.CustomerRepository;
import com.osa.repository.ISalonRepository;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceUnitTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ISalonRepository salonRepository;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    private AppointmentDTO sampleAppointmentDTO;
    private Appointment sampleAppointment;
    private Customer sampleCustomer;
    private SalonService sampleSalonService;

    @BeforeEach
    public void setUp() {
        sampleAppointmentDTO = new AppointmentDTO();
        sampleAppointmentDTO.setAppointmentId(1L);
        sampleAppointmentDTO.setCustomer_userId("sampleCustomerId");
        sampleAppointmentDTO.setService_id(101L);
        sampleAppointmentDTO.setPrefferedDate(LocalDate.now());
        sampleAppointmentDTO.setPrefferedTime(LocalTime.now());
        // Set other properties as needed

        sampleAppointment = new Appointment();
        BeanUtils.copyProperties(sampleAppointmentDTO, sampleAppointment);

        sampleCustomer = new Customer();
        // Initialize sample customer data
        sampleCustomer.setUserId("sampleCustomerId");
        // Set other customer properties

        sampleSalonService = new SalonService();
        // Initialize sample salon service data
        sampleSalonService.setServiceId(101L);
        // Set other salon service properties
    }

    @Test
    public void testAddAppointment() {
        when(customerRepository.findById(anyString())).thenReturn(Optional.of(sampleCustomer));
        when(salonRepository.findById(anyLong())).thenReturn(Optional.of(sampleSalonService));
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(sampleAppointment);

        AppointmentDTO result = appointmentService.addAppointment(sampleAppointmentDTO);

        assertNotNull(result);
        assertEquals(sampleAppointmentDTO.getAppointmentId(), result.getAppointmentId());
        // Add more assertions for other properties
    }

    @Test
    public void testRemoveAppointment() {
        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(sampleAppointment));

        AppointmentDTO result = appointmentService.removeAppointment(1L);

        assertNotNull(result);
        assertEquals(sampleAppointmentDTO.getAppointmentId(), result.getAppointmentId());
        // Add more assertions for other properties
        verify(appointmentRepository, times(1)).delete(any(Appointment.class));
    }

    @Test
    public void testGetAppointment() {
        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(sampleAppointment));

        AppointmentDTO result = appointmentService.getAppointment(1L);

        assertNotNull(result);
        assertEquals(sampleAppointmentDTO.getAppointmentId(), result.getAppointmentId());
        // Add more assertions for other properties
    }

    @Test
    public void testGetAllAppointment() {
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(sampleAppointment);

        when(appointmentRepository.findAll()).thenReturn(appointmentList);

        List<AppointmentDTO> result = appointmentService.getAllAppointment();

        assertNotNull(result);
        assertEquals(1, result.size());
        // Add more assertions for other properties
    }

    @Test
    public void testGetOpenAppointment() {
        // Mock behavior for appointmentRepository and test the getOpenAppointment method
        // Create sample data and assert the correct appointments are retrieved
    }
}

