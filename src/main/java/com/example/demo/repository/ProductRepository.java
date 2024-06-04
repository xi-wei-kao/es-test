package com.example.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.document.ProductDocument;

public interface ProductRepository 
	extends ElasticsearchRepository<ProductDocument, String> {
	
	List<ProductDocument> findByName(String name);
	
}
