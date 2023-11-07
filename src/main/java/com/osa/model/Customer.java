package com.osa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	private String userId; 
	
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "customer_address",
			joinColumns = @JoinColumn(
					name = "customer_id", referencedColumnName = "userId"
					),
			inverseJoinColumns = @JoinColumn(
					name = "address_id", referencedColumnName = "addressId")
			
			)
	private Set<Address> address = new HashSet<Address>();
	
	
}
