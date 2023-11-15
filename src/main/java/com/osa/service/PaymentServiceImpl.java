package com.osa.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.PaymentDTO;
import com.osa.exception.PaymentNotFoundException;
import com.osa.model.Appointment;
import com.osa.model.Card;
import com.osa.model.Payment;
import com.osa.repository.AppointmentRepository;
import com.osa.repository.CardRepository;
import com.osa.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService{
	
	//Payment Repository
	private IPaymentRepository paymentrepository;
		
    @Autowired
	public void setPaymentrepository(IPaymentRepository paymentrepository) {
		this.paymentrepository = paymentrepository;
	}
    
    //Appointment Repository
  	private AppointmentRepository appointmentRepository;
  		
  	@Autowired
  	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
  		this.appointmentRepository = appointmentRepository;
  	}
  	
  //Card Repository
  	private CardRepository cardrepository;
  	
  	@Autowired
	public void setCardrepository(CardRepository cardrepository) {
		this.cardrepository = cardrepository;
	}

	@Override
	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
		Payment payment=new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		
		Card card = new Card();
		BeanUtils.copyProperties(paymentDTO.getCard(), card);
		cardrepository.save(card);
		payment.setCard(card);
		paymentrepository.save(payment);
		
		Appointment existing_appointment = appointmentRepository.findById(paymentDTO.getAppointmentId()).get();
		existing_appointment.setPayment(payment);
		appointmentRepository.save(existing_appointment);
		
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
		    Payment payment = paymentrepository.findById(id).get();
		    PaymentDTO paymentDTO1 = new PaymentDTO();
		    BeanUtils.copyProperties(payment, paymentDTO1);
		    paymentrepository.delete(payment);
		return paymentDTO1;
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
