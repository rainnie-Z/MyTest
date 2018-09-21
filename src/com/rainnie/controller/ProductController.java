package com.rainnie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainnie.po.Category;
import com.rainnie.po.Product;
import com.rainnie.service.ProducService;

import sun.net.www.content.text.plain;

@Controller
public class ProductController {
	
	@Autowired
	private ProducService producService;
	
	@RequestMapping("queryProducts.do")
	public String queryProducts(Model model) {
		
		List<Product> products=producService.queryProducts();
		model.addAttribute("products",products);
		return "product-list";
		
	}
	
	@RequestMapping("toinsert.do")
	public String toInsert(Model model) {
		List<Category> categories =producService.queryAllCategory();
		model.addAttribute("categories",categories);
		return "insert-form";
		
	}
	
	@RequestMapping("insertProduct.do")
	public String insertProduct(Product product) {
		int result=producService.insertProduct(product);
		if(result>0) {
			return "redirect:queryProducts.do";
		}else {
			return "error";
		}
		 
	}
	
	@RequestMapping("deleteProduct.do")
	public String deleteProduct(Product product) {
		int result=producService.deleteProduct(product.getId());
		if(result>0) {
			return "redirect:queryProducts.do";
		}else {
			return "error";
		}
		
	}
	
	@RequestMapping("editProduct.do")
	public String toUpdate(Product product,Model model) {
		Product p=producService.queryProductById(product.getId());
		List<Category> allCategories =producService.queryAllCategory();
		model.addAttribute("product", p);
		model.addAttribute("allCategories",allCategories);
		return "update-form";
	}
	
	@RequestMapping("updateProduct")
	public String updateProduct(Product product) {
		int result=producService.updateProduct(product);
		if(result>0) {
			return "redirect:queryProducts.do";
		}else {
			return "error";
		}
		
		
	}
}
