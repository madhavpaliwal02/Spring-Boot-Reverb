package com.simple_crud.service;

import java.util.List;

import com.simple_crud.model.Product;

public interface ProductService {

	// Create Product
	public Product createProduct(Product product);
	
	// Get all products
	public List<Product> getProduct();
	
	// Get a product
	public Product getProduct(long id);
	
	// Update product
	public Product updateProduct(long id, Product product);
	
	// Delete product
	public void deleteProduct(long id);
}
