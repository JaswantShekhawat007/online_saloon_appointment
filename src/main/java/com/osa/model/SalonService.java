package com.osa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
	
	private String serviceName;
	
//	@NotEmpty(message="Mention price")
	private String servicePrice;
	
//	@NotEmpty(message = "duration")
	private String serviceDuration;
	
//	@NotEmpty(message = "discount")
	private long discount;	
//	@OneToOne(mappedBy = "serviceName")
//	private Appointment appointment;
	
	
}
