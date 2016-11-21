package edu.mum.ea.crs.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.ea.crs.data.domain.Payment;


public interface PaymentDAO extends JpaRepository<Payment, Integer> {

}
