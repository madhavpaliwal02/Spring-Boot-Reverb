package com.simple_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple_crud.model.Product;
import com.simple_crud.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
public class ProductCtrl {

	@Autowired
	private ProductService productService;

	// Create Product
	@PostMapping
	public ResponseEntity<Product> createProductHandler(@RequestBody Product product) {
		Product pro =  this.productService.createProduct(product);
		return new ResponseEntity<>(pro, HttpStatus.CREATED);
	}

	// Get All Products
	@GetMapping
	public ResponseEntity<List<Product>> getAllProductHandler() {
		List<Product> list =  this.productService.getProduct();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Get a Product
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductHandler(@PathVariable("id") long id) {
		Product pro = this.productService.getProduct(id);
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	// Update Product
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product, @PathVariable("id") long id){
		Product pro = this.productService.updateProduct(id, product);
		return new ResponseEntity<>(pro, HttpStatus.CREATED);
	}

	// Delete Product
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteProdutHandler(@PathVariable("id") long id){
		this.productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
