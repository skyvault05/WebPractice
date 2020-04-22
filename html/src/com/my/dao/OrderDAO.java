package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.NotFoundException;
import com.my.sql.MyConnection;
import com.my.vo.Customer;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;
import com.my.vo.Product;

public class OrderDAO {
	public void insert(OrderInfo info) throws AddException{
		Connection con = null;
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			insertOrderInfo(con, info);
			insertOrderLine(con, info);
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void insertOrderInfo(Connection con, OrderInfo info) throws SQLException{
		PreparedStatement pstmt =null;
		String insertOrderInfoSQL = "INSERT INTO order_info(order_no,order_id) VALUES (ORDER_SEQ.NEXTVAL, ?)";
		
		pstmt = con.prepareStatement(insertOrderInfoSQL);
		pstmt.setString(1, info.getOrder_customer().getId());
		pstmt.executeUpdate();
		
		
	}

	private void insertOrderLine(Connection con, OrderInfo info) throws SQLException {
		PreparedStatement pstmt =null;
		String insertOrderLineSQL ="INSERT INTO order_line(order_no, order_prod_no, order_quantity) VALUES (ORDER_SEQ.CURRVAL, ?, ?)";
		pstmt = con.prepareStatement(insertOrderLineSQL);
		for(OrderLine line:info.getLines()) {
			pstmt.setString(1, line.getOrder_product().getProd_no());
			pstmt.setInt(2, line.getOrder_quantity());
			pstmt.addBatch();
		}
		pstmt.executeBatch();			
	}

	public List<OrderInfo> selectById(String id) throws NotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();		
			String selectByIdSQL = 
					"SELECT order_no, order_id, order_dt\r\n" + 
							",name\r\n" + 
							",order_prod_no,   order_quantity\r\n" +
							",prod_name,   prod_price\r\n"+
							"FROM ORDER_INFO NATURAL JOIN ORDER_LINE\r\n" + 
							"JOIN customer c ON order_info.order_id = c.id\r\n" + 
							"JOIN product p ON order_line.order_prod_no = p.prod_no\r\n" + 
							"WHERE order_id=? ORDER BY order_no DESC";
			pstmt = con.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			List<OrderInfo> infos = new ArrayList<>();
			OrderInfo info = null;
			List<OrderLine> lines=null;
			int old_order_no = 0;//이전주문번호
			while(rs.next()) {				
				//이전 행과 주문번호가 다르면
				//1.첫행이 아니면 이전 orderInfo객체를 infos에 누적한다
				//2.orderInfo객체를 새로 생성한다				
				int new_order_no = rs.getInt("order_no");
				if(old_order_no != new_order_no){					
					if(info != null) {  //첫행이 아니면
						infos.add(info); //info누적
						System.out.println("info누적");
					}
					info = new OrderInfo(); 
					lines = new ArrayList<>();
					info.setLines(lines);

					info.setOrder_no(new_order_no);//주문번호
					Customer c = new Customer();
					c.setId(rs.getString("order_id"));//주문자아이디
					c.setName(rs.getString("name")); //주문자이름
					info.setOrder_customer(c);	

					info.setOrder_dt(rs.getDate("order_dt")); //주문일자
					old_order_no = new_order_no;
				}
				
				Product p = new Product();
				p.setProd_no(rs.getString("order_prod_no")); //주문상품번호
				p.setProd_name(rs.getString("prod_name")); //상품명
				p.setProd_price(rs.getInt("prod_price"));  //상품가격

				OrderLine line = new OrderLine();
				line.setOrder_product(p);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				lines.add(line);				
			}
			if(info != null) {
				infos.add(info); //info누적
			}
			if(infos.size() == 0) {
				throw new NotFoundException("아이디에 해당하는 주문이 없습니다");
			}
			return infos;
		} catch (Exception e) {			
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}finally {
			MyConnection.close(con, pstmt, rs);
		}
	}
	public OrderInfo  selectByNo(int order_no) throws NotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			String selecyByNoSQL = 
					"SELECT order_no, order_id, order_dt"
							+ "      ,name"
							+ "      ,order_prod_no,   order_quantity"
							+ "      ,prod_name,   prod_price"
							+ " FROM ORDER_INFO NATURAL JOIN ORDER_LINE"
							+ " JOIN customer c ON order_info.order_id = c.id"
							+ " JOIN product p ON order_line.order_prod_no = p.prod_no"
							+ " WHERE order_no = ?";
			pstmt = con.prepareStatement(selecyByNoSQL);
			pstmt.setInt(1, order_no);
			rs = pstmt.executeQuery();
			boolean isFirst = false;
			OrderInfo info = new OrderInfo();
			List<OrderLine> lines = new ArrayList<>();
			info.setLines(lines);
			while(rs.next()) {
				if(!isFirst) {  //첫번째 행
					info.setOrder_no(rs.getInt("order_no"));//주문번호
					Customer c = new Customer();
					c.setId(rs.getString("order_id"));//주문자아이디
					c.setName(rs.getString("name")); //주문자이름
					info.setOrder_customer(c);	

					info.setOrder_dt(rs.getDate("order_dt")); //주문일자
					isFirst = true;
				}
				Product p = new Product();
				p.setProd_no(rs.getString("order_prod_no")); //주문상품번호
				p.setProd_name(rs.getString("prod_name")); //상품명
				p.setProd_price(rs.getInt("prod_price"));  //상품가격

				OrderLine line = new OrderLine();
				line.setOrder_product(p);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				lines.add(line);
			}
			if(info.getLines().size() == 0) {
				throw new NotFoundException(
						"주문번호에 해당하는 주문이 없습니다");
			}
			return info;
		} catch (Exception e) {			
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}finally {
			MyConnection.close(con, pstmt, rs);
		}
	}
}

