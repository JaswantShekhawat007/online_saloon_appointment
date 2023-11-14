package com.osa.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.CardDTO;
import com.osa.dto.CustomerDTO;
import com.osa.dto.PaymentDTO;
import com.osa.exception.OrderNotFoundException;
import com.osa.exception.PaymentNotFoundException;
import com.osa.model.Card;
import com.osa.model.Customer;
import com.osa.model.Order;
import com.osa.model.Payment;
import com.osa.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService{
	@Autowired
	private IPaymentRepository paymentrepository;
	

	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		paymentrepository.save(payment);

		return paymentDTO;
	}
    
	@Override
    public PaymentDTO removePayment(long id) {
		
		if(paymentrepository.existsById(id)) {
		    Payment payment = paymentrepository.findById(id).get();
		    PaymentDTO paymentDTO = new PaymentDTO();
		    BeanUtils.copyProperties(payment, paymentDTO);
		    paymentrepository.delete(payment);
		return paymentDTO;
		}
		else {
			throw new PaymentNotFoundException("Payment with id " + id + " does not exist");
		}
	}

	@Override
	public PaymentDTO updatePayment(long id, PaymentDTO paymentDTO) {
		if(paymentrepository.existsById(id)) {
			Payment existingpayment = paymentrepository.findById(id).get();
			BeanUtils.copyProperties(paymentDTO, existingpayment);
			paymentrepository.save(existingpayment);
			return paymentDTO;
		}
		else {
			throw new PaymentNotFoundException("Payment with id " + id + " does not exist.");
		}
	}

	@Override
	public PaymentDTO getPaymentDetails(long id) {
		Optional<Payment> findById = paymentrepository.findById(id);
		if (findById.isPresent()) {
		    PaymentDTO paymentDTO = new PaymentDTO();
			BeanUtils.copyProperties(findById, paymentDTO);
			return paymentDTO;
		} else {
			throw new PaymentNotFoundException("Payment with id " + id + " does not exist");
		}
	}

	
		public List<PaymentDTO> getAllPaymentDetails() {
			List<Payment> payments = paymentrepository.findAll();
			List<PaymentDTO> paymentDTOs = new ArrayList<PaymentDTO>();
			for (Payment payment : payments) {
				PaymentDTO paymentDTO = new PaymentDTO();
				BeanUtils.copyProperties(payment, paymentDTO);
				paymentDTOs.add(paymentDTO);
			}
			return paymentDTOs;
		} 
	

}

