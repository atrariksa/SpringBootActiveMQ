package com.example.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core.model.Product;
import com.example.core.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
    ProductRepository productRepository;

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findProductByID(long id) {
		// TODO Auto-generated method stub
		Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
	}

	@Override
	public void addProduct(String name, String code) {
		// TODO Auto-generated method stub
		Product newProduct = new Product();
		newProduct.setName(name);
		newProduct.setCode(code);
		productRepository.save(newProduct);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
	}

	@Override
	public Product findProductByCode(String code) {
		// TODO Auto-generated method stub
//		Optional<Product> opt = productRepository.findProductByCode(code);
//        if (opt.isPresent())
//            return opt.get();
//        else
            return null;
	}
	
	@Override
	public List<Product> findAllProductWithFilterCode(String code) {
		// TODO Auto-generated method stub
		Optional<List<Product>> opt = productRepository.findAllProductByCode(code);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
	}

}
