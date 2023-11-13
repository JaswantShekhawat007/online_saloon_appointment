package com.osa.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osa.enums.ServiceName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalonServiceDTO {
	
	@NotEmpty
	private long serviceId;
	
	private String serviceName;
	
	@NotEmpty
	private String servicePrice;
	
	@NotEmpty
	private String serviceDuration;
	
	@NotNull
	private int discount;
	
}
