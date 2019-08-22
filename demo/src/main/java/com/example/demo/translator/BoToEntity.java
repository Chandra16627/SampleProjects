package com.example.demo.translator;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bo.Order;
import com.example.demo.bo.Product;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ProductEntity;

public class BoToEntity {

	public static ProductEntity productBotoProductEntity(Product product){
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(product.getProdId());
		productEntity.setName(product.getProdName());
		return productEntity;
	}
	
	public static Product productEntityToProductBo(ProductEntity entity){
		
		Product product = new Product();
		product.setProdId(entity.getId());
		product.setProdName(entity.getName());
		return product;
	}
	
	public static OrderEntity orderBotoOrderEntity(Order order) {

		OrderEntity orderEntity = new OrderEntity();
		List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
		orderEntity.setUserId(order.getUserId());
		for(Product product : order.getProducts()){
			productEntities.add(productBotoProductEntity(product));
		}
		orderEntity.setProducts(productEntities);
		return orderEntity;
	}
}
