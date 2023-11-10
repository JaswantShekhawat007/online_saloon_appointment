package com.osa.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.PaymentDTO;
import com.osa.exception.PaymentNotFoundException;
import com.osa.model.Payment;
import com.osa.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService{
	private IPaymentRepository paymentrepository;
	
	
    @Autowired
	public void setPaymentrepository(IPaymentRepository paymentrepository) {
		this.paymentrepository = paymentrepository;
	}

	@Override
	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
		Payment payment=new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		paymentrepository.save(payment);
		return paymentDTO;
	}

	@Override
    public PaymentDTO removePayment(long id) {
		PaymentDTO paymentDTO = getPaymentDetails(id);
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		paymentrepository.delete(payment);
		return paymentDTO;
		
	}

	@Override
	public PaymentDTO updatePayment(long id, Payment payment) {
		PaymentDTO paymentDTO= new PaymentDTO();
		BeanUtils.copyProperties(paymentDTO, payment);
		paymentrepository.save(payment);
		return paymentDTO;
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

	@Override
	public List<PaymentDTO> getAllPaymentDetails() {
		List<Payment> paymentsdetails = paymentrepository.findAll();
		List<PaymentDTO> paymentDTOs = new ArrayList<>();
		for (Payment entity : paymentsdetails) {
			PaymentDTO paymentDTO = new PaymentDTO();
			BeanUtils.copyProperties(entity, paymentDTO);
			paymentDTOs.add(paymentDTO);
		}
		return paymentDTOs;
	}
	
	

}
