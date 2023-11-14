package com.osa.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalonServiceDTO {

	private long serviceId;
	
	@NotBlank(message = "service name empty")
	@JsonProperty("service_name")
	private String serviceName;
	
	@NotBlank(message="Mention price")
	@JsonProperty("service_price")
	private String servicePrice;
	
	@NotBlank(message = "duration")
	@JsonProperty("service_duration")
	private String serviceDuration;
	
	@NotBlank(message = "discount")
	private long discount;	
	
	
}
