package com.iesvirgendelcarmen.app4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesvirgendelcarmen.app4.entity.Product;
import com.iesvirgendelcarmen.app4.service.ProductService;
import com.iesvirgendelcarmen.app4.service.ProductServiceImp;

@Controller
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	//crear un producto
	@PostMapping
	public ResponseEntity<?> create(@RequestBody  Product product){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(productService.save(product));
	}
	//actualizar un producto
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(
			@PathVariable(value = "id") long idValue,
			@RequestBody  Product product){
		Optional<Product> oProduct = productService.findById(idValue);
		if (! oProduct.isPresent())
			return ResponseEntity.notFound().build();
		oProduct.get().setName(product.getName());
		oProduct.get().setPrice(product.getPrice());
		return ResponseEntity.status(200).body(
				productService.save(oProduct.get()));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(
			@PathVariable(value = "id") long idValue) {
		Optional<Product> oProduct = productService.findById(idValue);
		if (! oProduct.isPresent())
			return ResponseEntity.notFound().build();
		productService.deleteById(idValue);
		return ResponseEntity.ok(oProduct.get());
	}
	
	@GetMapping
	public ResponseEntity<?> getAllProducts () {
		return ResponseEntity.ok(productService.findAll());
	}
	
	
	
	
	//leer un producto dada la id
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(
			@PathVariable(value = "id") long idValue) {
			System.out.println("get by id");
				Optional<Product> oProduct = productService.findById(idValue);
				if (! oProduct.isPresent())
					return ResponseEntity.notFound().build();
				return ResponseEntity.ok(oProduct);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
