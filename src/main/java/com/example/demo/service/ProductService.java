package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.document.ProductDocument;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ResponseEntity<ProductDocument> process(ProductDocument reqBody) {
		
		ProductDocument savedDoc = productRepository.save(reqBody);
		
		Optional<ProductDocument> productDocOpt = productRepository.findById(savedDoc.getId());
		
		return new ResponseEntity<ProductDocument>(HttpStatus.valueOf(200))
				.ok(productDocOpt.orElse(ProductDocument.builder().build()));
	}
	
}
