package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.PaymentDAO;
import edu.mum.ea.crs.data.domain.Payment;

@Service
public class PaymentService {

	@Resource
	PaymentDAO dao;

	public List<Payment> findAll(){
		return dao.findAll();
	}
	public void delete(int id){
		dao.delete(id);
	}
	public void update(Payment payment){
		dao.save(payment);
		
	}
	public Payment getPaymentById(int id){
		return dao.findOne(id);
	}
}
