package com.my.service;

import java.util.List;

import com.my.dao.CustomerDAO;
import com.my.dao.ProductDAO;
import com.my.exception.AddException;
import com.my.exception.ModifyException;
import com.my.exception.NotFoundException;
import com.my.vo.Customer;
import com.my.vo.Product;

public class ProductService {
	private static ProductService service = new ProductService();
	private ProductDAO dao;
	private ProductService() {
		dao = new ProductDAO();
	}
	public static ProductService getInstance(){
		return service;
	}
	
	public Product findByNo(String prod_no)  throws NotFoundException{
		return dao.selectByNo(prod_no);
	}
	
	public List<Product> findByName(String word) throws NotFoundException{
		return dao.selectByName(word);
	}
	
	public List<Product> findAll() throws NotFoundException{
		return dao.selectAll();
	}
}