package com.rainnie.dao;

import java.util.List;
import java.util.Map;



import com.rainnie.po.Category;
import com.rainnie.po.Product;

public interface ProductMapper {
	
	
	public List<Product> queryProducts();
	
	public int insertProduct(Product product);
	
	public int deleteProduct(Integer id);
	
	public Product queryProductById(Integer id);
	
	public int updateProduct(Product product);
	
	public List<Category> queryCategories(Map<String, Object> map);
	
	public List<Category> queryAllCategory();
	
	public List<Category> queryCategoriesByPid(Integer pid);
	
	public int insertProductCategory(Map<String, Object> map);
	
	public int deleteProductCategoryByPid(Integer pid);
	
	
	
	
	
}
