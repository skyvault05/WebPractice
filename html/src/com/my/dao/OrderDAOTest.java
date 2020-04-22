package com.my.dao;

import java.util.List;

import com.my.exception.NotFoundException;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;
import com.my.vo.Product;

public class OrderDAOTest {

	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		String id = "id1";
		try {
			List<OrderInfo> infos = dao.selectById(id);
			
			for(OrderInfo info: infos) {
				System.out.println("주문번호:" + info.getOrder_no());
				System.out.println("주문일자: " + info.getOrder_dt());
				System.out.println("주문상세정보");
				List<OrderLine> lines = info.getLines();
				for(OrderLine line: lines) {
					Product p = line.getOrder_product();
					int order_quantity = line.getOrder_quantity();
					System.out.println(p.getProd_no() + ":" 
									+ p.getProd_name() + ":" 
									+ p.getProd_price() + ":" 
									+ order_quantity);
				}
				System.out.println("--------------------");
			}
		} catch (NotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		//int order_no = 1;
//		int order_no = 999;
//		try {
//			OrderInfo info = dao.selectByNo(order_no);
//			System.out.println("주문자: "+ info.getOrder_customer());
//			System.out.println("주문일자: " + info.getOrder_dt());
//			System.out.println("주문상세정보");
//			List<OrderLine> lines = info.getLines();
//			for(OrderLine line: lines) {
//				Product p = line.getOrder_product();
//				int order_quantity = line.getOrder_quantity();
//				System.out.println(p.getProd_no() + ":" 
//								+ p.getProd_name() + ":" 
//								+ p.getProd_price() + ":" 
//								+ order_quantity);
//			}
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//		}

	}

}







