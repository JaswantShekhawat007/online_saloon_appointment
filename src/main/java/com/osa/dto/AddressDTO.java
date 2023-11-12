package com.osa.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	
	private Integer id;
	
	@NotEmpty(message = "Empty Field Door Number")
	private String doorNo;
	
	@NotEmpty(message = "Empty Field Street")
	private String street;
	
	@NotEmpty(message = "Empty Field Area")
	private String area;
	
	@NotEmpty(message = "Empty Field City")
	private String city;
	
	@NotEmpty(message = "Empty Field State")
	private String state;
	
	@NotNull
	@Size(max=6, min=6,message = "Invalid Pincode")
	private int pincode;
	
	@JsonIgnore
	private List<CustomerDTO> customerDTO ;
	
}
