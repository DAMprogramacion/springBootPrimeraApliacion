package com.iesvirgendelcarmen.app4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	
}
