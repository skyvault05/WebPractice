package com.my.dao;

import java.util.List;

import com.my.exception.NotFoundException;
import com.my.vo.Customer;

public class CustomerDAOTest {
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		try {
			//List<Customer>list = dao.selectByName("n");
			List<Customer>list = dao.selectByName("aaa");
			for(Customer c: list) {
				System.out.println(c);
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
//		try {
//			List<Customer>list = dao.selectAll();
//			for(Customer c: list) {
//				System.out.println(c);
//			}
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//		}
//		Customer c;
//		try {
//			//c = dao.selectById("idt"); //ok
//			c = dao.selectById("not"); 
//			System.out.println(c);
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//		}
	
//		Customer c = 
//			new Customer("idt", "pt", "nt", "M", null, 1);//ok
//			//new Customer("id1", "pt", "nt", "M", null, 1); //id以묐났PK
//			//new Customer("idt2", "pt", "nt", "A", null, 1);//gender CHECK
//		try {
//			dao.insert(c);
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
	}

}
