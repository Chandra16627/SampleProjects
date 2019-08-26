package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bo.Order;
import com.example.demo.bo.Product;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.translator.BoToEntity;

@Service
public class BagService {

	@Autowired
	private ProductRepository bagRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Integer addProduct(Product product){
		ProductEntity productEntity = BoToEntity.productBotoProductEntity(product);
		bagRepository.save(productEntity);
		return productEntity.getId();
	}
	
	public List<Product> getAllProducts(){
		
		List<ProductEntity> entities = (List<ProductEntity>) bagRepository.findAll();
		List<Product> products = new ArrayList<Product>();
		for(ProductEntity entity : entities){
			products.add(BoToEntity.productEntityToProductBo(entity));
		}
		return products;
	}
	
	public void deleteProduct(Product product){
		bagRepository.delete(BoToEntity.productBotoProductEntity(product));
	}
	
	public void updateProduct(Product product){
		bagRepository.save(BoToEntity.productBotoProductEntity(product));
	}
	
	public void placeOrder(Order order){
		OrderEntity orderEntity = BoToEntity.orderBotoOrderEntity(order);
		orderRepository.save(orderEntity);
	}
}
