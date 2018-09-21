package com.rainnie.service;

import java.util.List;
import java.util.Map;

import com.rainnie.po.Category;
import com.rainnie.po.Product;

public interface ProducService {
	public List<Product> queryProducts();
	
	public int insertProduct(Product product);
	
	public int deleteProduct(Integer id);
	
	public Product queryProductById(Integer id);
	public int updateProduct(Product product);
	
	public List<Category> queryAllCategory();
	
	
	
}
