package com.my.service;

import java.util.List;

import com.my.dao.OrderDAO;
import com.my.exception.AddException;
import com.my.exception.NotFoundException;
import com.my.vo.OrderInfo;

public class OrderService {
	private static OrderService service = new OrderService();
	private OrderDAO dao;
	private OrderService() {
		dao = new OrderDAO();
	}
	public static OrderService getInstance() {
		return service;
	}
	public List<OrderInfo> findById(String id) throws NotFoundException{
		return dao.selectById(id);
	}
	public void addOrder(OrderInfo info) throws AddException{
		dao.insert(info);
	}
}
