package com.rainnie.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainnie.dao.ProductMapper;
import com.rainnie.po.Category;
import com.rainnie.po.Product;
import com.rainnie.service.ProducService;

@Service
public class ProductServiceImpl implements ProducService{
	
	@Autowired
	private ProductMapper productService;

	@Override
	public List<Product> queryProducts() {
		
		//1.产品表 查产品信息
		List<Product> products = productService.queryProducts();
		//2.中间表+分类表  根据当前产品的id查询分类
		for(Product product:products) {
			Integer pid=product.getId();
			List<Category> categories=productService.queryCategoriesByPid(pid);
			product.setCategories(categories);
			
		}
		return products;
	}

	@Override
	public int insertProduct(Product product) {
		//1.产品表   当前产品插入，自动生成产品id
		productService.insertProduct(product);
		//除了要多产品表插入数据外，也要相应的对中间表插入数据
		//2.中间表   把当前产品的分类数据插入
		Integer pid=product.getId();
		String[] cids=product.getCids().split(",");
		for(String cid:cids) {
			System.out.println("cid:"+cid);
		}
		Map<String, Object> map=new HashMap<>();
		map.put("pid", pid);
		map.put("cids", cids);
		
		int result=productService.insertProductCategory(map);
		return result;
		
		
	}

	@Override
	public int deleteProduct(Integer id) {
		//1.中间表 根据当前产品的id删除分类
		productService.deleteProductCategoryByPid(id);
		
		//2.产品表 根据当前产品的id删除产品
		return productService.deleteProduct(id);
	}

	@Override
	public Product queryProductById(Integer id) {
		
		//1.产品表 查产品信息
		Product product = productService.queryProductById(id);
		
		
		//2.中间表+分类表  根据当前产品的id查询分类
		Integer pid=product.getId();
		List<Category> categories=productService.queryCategoriesByPid(pid);
		product.setCategories(categories);
		return product;
		
	}

	@Override
	public int updateProduct(Product product) {
		
		//return productService.updateProduct(product);
		//1.中间表   把当前产品以前的分类数据删掉
		productService.deleteProductCategoryByPid(product.getId());

		//2.中间表   把当前产品的新的分类数据插入
		Integer pid=product.getId();
		String[] cids=product.getCids().split(",");
		Map<String, Object> map=new HashMap<>();
		map.put("pid", pid);
		map.put("cids", cids);
		/*dao.insertProductCategory(map);*/
		productService.insertProductCategory(map);
		
		//3.产品表   修改当前产品数据
		/*int result=dao.updateProduct(product);*/
		int result=productService.updateProduct(product);
		
		return result;
	}

	@Override
	public List<Category> queryAllCategory() {
		
		return productService.queryAllCategory();
	}

	
	
	

}
