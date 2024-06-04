package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Document(indexName = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductDocument {

    @Id
    private String id;
    
    private String name;
    
    private String description;
    
    private double price;
}
