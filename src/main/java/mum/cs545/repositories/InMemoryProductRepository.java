package mum.cs545.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mum.cs545.model.Product;

@Repository
public class InMemoryProductRepository implements ProductRepository {
	List<Product> productsList;
	public InMemoryProductRepository(){
		productsList = new ArrayList<Product>();
		productsList.add(new Product("p4","Think Pad",450.5,"Business Machine","Lenovo","Laptop",34,5,false,"New"));
		productsList.add(new Product("p5","Mac Book Pro",949.99,"Professional Machine","Apple","Laptop",23,15,false,"New"));
		productsList.add(new Product("p1","Dell",949.99,"Professional Machine","Apple","Laptop",23,15,false,"New"));
		productsList.add(new Product("p2","Hp",949.99,"Professional Machine","Apple","Laptop",23,15,false,"New"));
		productsList.add(new Product("p3","Acer",949.99,"Professional Machine","Apple","Laptop",23,15,false,"New"));
	}
	@Override
	public List<Product> getAllProducts() {
		return productsList;
	}
	@Override
	public Product getProductById(String id) {
		for(Product p:productsList){
			if(p.getProductId().equals(id)){
				return p;
			}
		}
		return null;
	}
}
