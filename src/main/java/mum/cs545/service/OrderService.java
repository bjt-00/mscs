package mum.cs545.service;

import java.util.List;

import mum.cs545.model.Product;

public interface OrderService {

	public List<Product> getAllProducts();
	public Product getProductById(String id);
}
