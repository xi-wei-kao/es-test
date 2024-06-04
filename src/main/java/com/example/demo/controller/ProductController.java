package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.ProductDocument;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<ProductDocument> testProduct(
			@RequestBody ProductDocument reqBody) {
		
		return productService.process(reqBody);
		
	}
	
}
