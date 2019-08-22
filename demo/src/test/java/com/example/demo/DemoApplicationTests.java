package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.doThrow;

import com.example.demo.bo.Product;
import com.example.demo.controller.BagController;
import com.example.demo.service.BagService;


public class DemoApplicationTests {

	@InjectMocks
	private BagController bagController;
	
	@Mock
	private BagService bagService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllProducts(){
		when(bagService.getAllProducts()).thenReturn(getDataSet1());
		List<Product> products = bagController.getAllProducts();
		Assert.assertEquals("D", products.get(0).getProdName());
	}
	
	@Test
	public void testGetAllProducts2(){
		when(bagService.getAllProducts()).thenReturn(getDataSet2());
		List<Product> products = bagController.getAllProducts();
		Assert.assertEquals("C", products.get(0).getProdName());
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetAllProducts3(){
		
		doThrow(new RuntimeException("Service not yet implemented")).when(bagService).getAllProducts();
		List<Product> products = bagController.getAllProducts();
//		Assert.assertEquals("Service not yet implemented", bagController.getAllProducts());
		
	}
	
	public List<Product> getDataSet1(){
		List<Product> products = new ArrayList<Product>();
		Product p1= new Product();
		p1.setProdId(1);
		p1.setProdName("A");
		Product p2= new Product();
		p2.setProdId(1);
		p2.setProdName("B");
		products.add(p1);
		products.add(p2);
		return products;
	}
	
	public List<Product> getDataSet2(){
		List<Product> products = new ArrayList<Product>();
		Product p1= new Product();
		p1.setProdId(3);
		p1.setProdName("C");
		Product p2= new Product();
		p2.setProdId(4);
		p2.setProdName("D");
		products.add(p1);
		products.add(p2);
		return products;
	}
	
	/*public List<Product> getDataSet3(){
		
		List<Product> products = null;
		try{
			 products = new ArrayList<Product>(1);
			 products.get(2);
		}catch(Exception e){
			throw
		}
		return products;
	}*/

}
