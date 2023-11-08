package com.osa.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	
	private Integer id;
	
	@NotEmpty
	private String doorNo;
	
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String area;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	@NotNull
	@Size(max=6, min=6)
	private int pincode;
	
}
