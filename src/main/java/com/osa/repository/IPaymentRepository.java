package com.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osa.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long>{

}
