package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.Order;
import com.example.demo.bo.Product;
import com.example.demo.service.BagService;

@RestController
@RequestMapping("/bag/v1")
public class BagController {

	@Autowired
	BagService bagService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {

		List<Product> products = bagService.getAllProducts();
		return products;
	}

	@PostMapping("/product")
	public String add(@RequestBody Product product) {
		int id = 0;
		try {
			 id = bagService.addProduct(product);
		} catch (Exception e) {
			throw e;
		}
		return id + " Added Successfully";
	}

	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order) {
		try {
			bagService.placeOrder(order);
		} catch (Exception e) {
			throw e;
		}
		return "Order placed successfully";
	}
}
