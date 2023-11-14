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
        sampleServiceDTO.setServiceName("Haircut");
        sampleServiceDTO.setServicePrice("25.0");
        sampleServiceDTO.setServiceDuration("1 hour");
        sampleServiceDTO.setDiscount(10);
        // Set other properties for sampleServiceDTO

        sampleService = new SalonService();
        sampleService.setServiceId(1L);
        sampleService.setServiceName("Haircut");
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
        List<SalonService> services = new ArrayList<>();
        services.add(sampleService);

        when(salonRepository.getServicesByName()).thenReturn(services);

        List<SalonServiceDTO> result = salonService.getServicesByName();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(sampleServiceDTO.getServiceId(), result.get(0).getServiceId());
        // Add more assertions for other properties
    }

    @Test
    public void testGetServicesByPrice() {
        List<SalonService> services = new ArrayList<>();
        services.add(sampleService);

        when(salonRepository.getServicesByPrice()).thenReturn(services);

        List<SalonServiceDTO> result = salonService.getServicesByPrice();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(sampleServiceDTO.getServiceId(), result.get(0).getServiceId());
        // Add more assertions for other properties
    }

    @Test
    public void testGetServicesByDuration() {
        List<SalonService> services = new ArrayList<>();
        services.add(sampleService);

        when(salonRepository.getServicesByDuration()).thenReturn(services);

        List<SalonServiceDTO> result = salonService.getServicesByDuration();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(sampleServiceDTO.getServiceId(), result.get(0).getServiceId());
        // Add more assertions for other properties
    }

}
