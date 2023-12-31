package com.osa.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.osa.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerDTO extends UserDTO{
	
	@NotEmpty(message = "Name Field Empty")
	private String name;
	
	@NotNull(message = "Email Field Empty")
	@Email(message = "Invalid Email")
	private String email;
	
	@NotEmpty(message = "Please provide contact number")
	@Size(max=10, min=10, message = "Invalid contact number")
	private String contactNo;
	
	@Past(message = "Invalid Date of Birth")
	private LocalDate dob;
	
	
	private List<Address> address; 
	
//	@Column(name = "customer")
//    List<Order> order;
}
