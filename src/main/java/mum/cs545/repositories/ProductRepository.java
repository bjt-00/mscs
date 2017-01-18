package mum.cs545.repositories;

import java.util.List;

import mum.cs545.model.Product;

public interface ProductRepository {

	public List<Product> getAllProducts();
	public Product getProductById(String id);
}
