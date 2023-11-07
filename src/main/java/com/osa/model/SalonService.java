package com.osa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private long serviceId;
	
	@Enumerated(EnumType.STRING)
	private ServiceName serviceName;
	
	private String servicePrice;
	private String serviceDuration;
	private int discount;
	
//	@OneToOne(mappedBy = "serviceName")
//	private Appointment appointment;
	
	
}
