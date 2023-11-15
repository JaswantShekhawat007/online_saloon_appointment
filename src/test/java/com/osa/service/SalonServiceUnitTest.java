package com.osa.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.osa.dto.SalonServiceDTO;
import com.osa.model.SalonService;
import com.osa.repository.ISalonRepository;

@ExtendWith(MockitoExtension.class)
public class SalonServiceUnitTest {

    @Mock
    private ISalonRepository salonRepository;

    @InjectMocks
    private ISalonServiceImpl salonService;

    private SalonServiceDTO sampleServiceDTO;
    private SalonService sampleService;

    @BeforeEach
    public void setUp() {
        // Initialize sample data
        sampleServiceDTO = new SalonServiceDTO();
        sampleServiceDTO.setServiceId(1L);
        sampleServiceDTO.setServiceName("HAIRCUT");
        sampleServiceDTO.setServicePrice("25.0");
        sampleServiceDTO.setServiceDuration("1 hour");
        sampleServiceDTO.setDiscount(10);
        // Set other properties for sampleServiceDTO

        sampleService = new SalonService();
        sampleService.setServiceId(1L);
        sampleService.setServiceName("HAIRCUT");
        sampleService.setServicePrice("25.0");
        sampleServiceDTO.setServiceDuration("1 hour");
        sampleServiceDTO.setDiscount(10);
        // Set other properties for sampleService
    }

    @Test
    public void testAddService() {
        when(salonRepository.save(any(SalonService.class))).thenReturn(sampleService);

        SalonServiceDTO result = salonService.addService(sampleServiceDTO);

        assertNotNull(result);
        assertEquals(sampleServiceDTO.getServiceId(), result.getServiceId());
        // Add more assertions for other properties
    }

    @Test
    public void testRemoveService() {
        when(salonRepository.findById(anyLong())).thenReturn(Optional.of(sampleService));

        SalonServiceDTO result = salonService.removeService(1L);

        assertNotNull(result);
        assertEquals(sampleServiceDTO.getServiceId(), result.getServiceId());
        // Add more assertions for other properties
        verify(salonRepository, times(1)).delete(any(SalonService.class));
    }

    @Test
    public void testUpdateService() {
        when(salonRepository.findById(anyLong())).thenReturn(Optional.of(sampleService));
        when(salonRepository.save(any(SalonService.class))).thenReturn(sampleService);

        SalonServiceDTO updatedServiceDTO = new SalonServiceDTO();
        updatedServiceDTO.setServiceId(1L);
        // Set other properties for the updatedServiceDTO

        SalonServiceDTO result = salonService.updateService(1L, updatedServiceDTO);

        assertNotNull(result);
        assertEquals(sampleServiceDTO.getServiceId(), result.getServiceId());
        // Add more assertions for other properties
    }

    @Test
    public void testGetService() {
        when(salonRepository.findById(anyLong())).thenReturn(Optional.of(sampleService));

        SalonServiceDTO result = salonService.getService(1L);

        assertNotNull(result);
        assertEquals(sampleServiceDTO.getServiceId(), result.getServiceId());
        // Add more assertions for other properties
    }

    @Test
    public void testGetAllServices() {
        List<SalonService> services = new ArrayList<>();
        services.add(sampleService);

        when(salonRepository.findAll()).thenReturn(services);

        List<SalonServiceDTO> result = salonService.getAllServices();

        assertNotNull(result);
        assertEquals(1, result.size());
        // Add more assertions for other properties
    }
    
    @Test
    public void testGetServicesByName() {
        // Mocking data
        String serviceName = "HAIRCUT";
        SalonService service1 = new SalonService();
        service1.setServiceName(serviceName);
        SalonService service2 = new SalonService();
        service2.setServiceName(serviceName);

        List<SalonService> services = new ArrayList<>();
        services.add(service1);
        services.add(service2);

        when(salonRepository.getServicesByName(serviceName)).thenReturn(services);

        // Calling the service method
        List<SalonServiceDTO> serviceDTOs = salonService.getServicesByName(serviceName);

        // Assertions
        assertEquals(2, serviceDTOs.size());
        assertEquals(serviceName, serviceDTOs.get(0).getServiceName());
        assertEquals(serviceName, serviceDTOs.get(1).getServiceName());
    }
    
    
    @Test
    public void testGetServicesByPrice() {
        // Mocking data
        String servicePrice = "25.0";
        SalonService service1 = new SalonService();
        service1.setServicePrice(servicePrice);
        SalonService service2 = new SalonService();
        service2.setServicePrice(servicePrice);

        List<SalonService> services = new ArrayList<>();
        services.add(service1);
        services.add(service2);

        when(salonRepository.getServicesByPrice(servicePrice)).thenReturn(services);

        // Calling the service method
        List<SalonServiceDTO> serviceDTOs = salonService.getServicesByPrice(servicePrice);

        // Assertions
        assertEquals(2, serviceDTOs.size());
        assertEquals(servicePrice, serviceDTOs.get(0).getServicePrice());
        assertEquals(servicePrice, serviceDTOs.get(1).getServicePrice());
    }

    
    @Test
    public void testGetServicesByDuration() {
        // Mocking data
        String serviceDuration = "1 hour";
        SalonService service1 = new SalonService();
        service1.setServiceDuration(serviceDuration);
        SalonService service2 = new SalonService();
        service2.setServiceDuration(serviceDuration);

        List<SalonService> services = new ArrayList<>();
        services.add(service1);
        services.add(service2);

        when(salonRepository.getServicesByDuration(serviceDuration)).thenReturn(services);

        // Calling the service method
        List<SalonServiceDTO> serviceDTOs = salonService.getServicesByDuration(serviceDuration);

        // Assertions
        assertEquals(2, serviceDTOs.size());
        assertEquals(serviceDuration, serviceDTOs.get(0).getServiceDuration());
        assertEquals(serviceDuration, serviceDTOs.get(1).getServiceDuration());
    }

}
