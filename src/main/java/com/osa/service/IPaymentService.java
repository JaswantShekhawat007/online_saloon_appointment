package com.osa.service;

import java.util.List;

import javax.validation.Valid;

import com.osa.dto.CardDTO;
import com.osa.dto.PaymentDTO;
import com.osa.model.Card;
import com.osa.model.Payment;

public interface IPaymentService {
	
	public PaymentDTO addPayment(PaymentDTO paymentDTO);
	public PaymentDTO removePayment(long id);
	public PaymentDTO updatePayment(long id,PaymentDTO paymentDTO);
	public PaymentDTO getPaymentDetails(long id);
	public List<PaymentDTO> getAllPaymentDetails();
}
