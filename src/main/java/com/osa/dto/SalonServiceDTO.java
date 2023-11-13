package com.osa.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalonServiceDTO {
	
	private long serviceId;
	
	private String serviceName;
	
	@NotEmpty(message="Mention price")
	private String servicePrice;
	
	@NotEmpty(message = "duration")
	private String serviceDuration;
	
	@NotEmpty(message = "discount")
	private long discount;
	
}
