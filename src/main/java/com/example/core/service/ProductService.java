package com.example.core.service;

import java.util.List;

import com.example.core.model.Product;

public interface ProductService {
    List<Product> findAllProduct();
    List<Product> findAllProductWithFilterCode(String code);
    Product findProductByID(long id);
    Product findProductByCode(String code);
    void addProduct(String name, String code);
    void deleteAllData();
}