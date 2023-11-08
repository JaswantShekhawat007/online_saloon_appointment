package com.osa.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerDTO extends UserDTO{
	
	private String user_id; 
	@NotEmpty
	private String name;
	@Email
	private String email;
	@NotEmpty
	@Size(max=10, min=10)
	private String contactNo;
	@Past
	private LocalDate dob;
	@Valid
	private AddressDTO address;
	
}
