package com.osa.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.osa.enums.ServiceName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SalonService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long serviceId;
	
	
	@Enumerated(EnumType.STRING)
	private ServiceName serviceName;
	
	
	private String servicePrice;
	
	
	private String serviceDuration;
	
	
	private int discount;
	
//	@OneToOne(mappedBy = "serviceName")
//	private Appointment appointment;
	
	
}
