package com.iesvirgendelcarmen.app4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iesvirgendelcarmen.app4.entity.Product;

@Service
public interface ProductService {
	
	public List<Product> findAll();
	public Optional<Product> findById(long id);
	public Product save(Product product);
	public void deleteById(long id);
	
}

