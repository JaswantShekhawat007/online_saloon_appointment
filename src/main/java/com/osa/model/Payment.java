package com.osa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
<<<<<<< HEAD
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
=======
import javax.persistence.Transient;
>>>>>>> 2845cb1dc5a94995c9b0e89081c61302729671fd


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")
	private long paymentId;
	
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="status")
	private String status;

		
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	
	private Card card;
<<<<<<< HEAD

}
=======
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId", nullable = true)
	Order order;
	
	@Transient
	private long appointmentId;
	
}
>>>>>>> 2845cb1dc5a94995c9b0e89081c61302729671fd
