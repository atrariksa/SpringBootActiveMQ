package com.example.core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.model.Product;
import com.example.core.service.ProductServiceImpl;

@RestController
@RequestMapping(path="/products", produces="application/json")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@GetMapping("")
	List<Product> getAllProducts(@RequestParam Optional<String> code) {
		if (code.isPresent() && !code.get().equals("")) {
			return productServiceImpl.findAllProductWithFilterCode(code.get());
		}
		return productServiceImpl.findAllProduct();
	}
	
	@GetMapping("/{id}")
	Product getProduct(@PathVariable("id") long id) {
		return productServiceImpl.findProductByID(id);
	}
	
}
