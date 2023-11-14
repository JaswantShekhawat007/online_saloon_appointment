package com.osa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonProperty("service_name")
	private String serviceName;
	
	@JsonProperty("service_price")
	private String servicePrice;
	
	@JsonProperty("service_duration")
	private String serviceDuration;

	private long discount;	
	
	
}
