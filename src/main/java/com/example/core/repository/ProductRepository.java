package com.example.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.core.model.Product;

// @Repository is a Spring annotation that
// indicates that the decorated class is a repository.
@Repository 
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query(value="select * from Product p where p.code=?1 limit 1", nativeQuery=true)
    Optional<Product> findProductByCode(String code);
	
	@Query("select p from Product p where p.code=?1")
    Optional<List<Product>> findAllProductByCode(String code);
}