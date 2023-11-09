package com.osa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
	
	@Id
	private Integer addressId;
	
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "address", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	private Set<Customer> customer;
	
}
