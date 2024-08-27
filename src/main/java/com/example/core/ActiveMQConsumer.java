package com.example.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.core.model.Product;
import com.example.core.service.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ActiveMQConsumer {
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Value("${queue.name}")
	private String queueName;
	
	@Value("${queue.product}")
	private String queueProduct;

	@JmsListener(destination = "${queue.name}")
	public void processMessage(String content) {
		System.out.println(queueName+" : "+content);
	}
	
	@JmsListener(destination = "${queue.product}")
	public void processProduct(String content) {
		System.out.println(queueProduct+" : "+content);
		try {
			Product product = null;
			ObjectMapper mapper = new ObjectMapper();
			product = mapper.readValue(content, Product.class);
			productServiceImpl.addProduct(product.getName(), product.getCode());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}