package com.osa.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Customer extends User {


	@Column(name="customer_name")
	private String name;
	
	
	private String email;
	
	
	private String contactNo;
	
	
	private LocalDate dob;
	
	@ManyToMany(/*fetch = FetchType.EAGER,*/ cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SELECT)
	@JoinTable(name = "customer_address",
		joinColumns = @JoinColumn(
				name = "customer_id", referencedColumnName = "userId")
		,
		inverseJoinColumns = @JoinColumn(
				name = "address_id", referencedColumnName = "addressId")
		
	)

	private List<Address> address;

	
}
