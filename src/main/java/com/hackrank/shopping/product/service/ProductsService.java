package com.hackrank.shopping.product.service;

import com.hackrank.shopping.product.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service	
public interface ProductsService {

	    ResponseEntity addProduct(Product product);
	    ResponseEntity updateProduct(Product product, long productId);
	    Product getProductById(@Min(value = 1L, message ="Invalid Product Id") Long id);
	    @NotNull Iterable<Product> filterProductsByCategory(String category);
	    @NotNull Iterable<Product> getAllProducts();
	    @NotNull Iterable<Product> filterProduct(String category, Boolean availability);
	}
	
	
	

