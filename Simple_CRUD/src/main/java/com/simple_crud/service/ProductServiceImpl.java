package com.simple_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_crud.model.Product;
import com.simple_crud.repo.ProductRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	// Create Product
	@Override
	public Product createProduct(Product product) {
		return this.productRepo.save(product);
	}

	@Override
	public List<Product> getProduct() {
		return this.productRepo.findAll();
	}

	@Override
	public Product getProduct(long id) {
		return this.productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Product oldProd = getProduct(id);
		if (oldProd == null)
			throw new EntityNotFoundException("Product not found");
		product.setId(id);
		return this.productRepo.save(product);
	}

	@Override
	public void deleteProduct(long id) {
		if (getProduct(id) == null)
			throw new EntityNotFoundException("Product not found");
		this.productRepo.deleteById(id);
	}

}
