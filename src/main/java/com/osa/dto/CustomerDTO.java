package com.osa.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.osa.model.Address;
import com.osa.model.Order;

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
	
	@NotEmpty
	@Email(message = "Invalid Email")
	private String email;
	
	@NotEmpty(message = "Please provide contact number")
	@Size(max=10, min=10, message = "Invalid contact number")
	private String contactNo;
	
	@NotEmpty
	@Past(message = "Invalid Date of Birth")
	private LocalDate dob;
	
	
	private List<Address> address; 
	
	@Column(name = "customer")
    List<Order> order;
	
}
