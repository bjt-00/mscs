package mum.cs545.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs545.model.Product;
import mum.cs545.repositories.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	ProductRepository repository;
	
	@Override
	public List<Product> getAllProducts(){
		return repository.getAllProducts();
	}

	@Override
	public Product getProductById(String id) {
		return repository.getProductById(id);
	}
}
