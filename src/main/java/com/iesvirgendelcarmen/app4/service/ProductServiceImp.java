package com.iesvirgendelcarmen.app4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iesvirgendelcarmen.app4.entity.Product;
import com.iesvirgendelcarmen.app4.repository.ProductRepository;
@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Transactional(readOnly = true)
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}
	@Transactional
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	@Transactional
	@Override
	public void deleteById(long id) {
		productRepository.deleteById(id);
	}

}
