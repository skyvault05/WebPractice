package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.ModifyException;
import com.my.exception.NotFoundException;
import com.my.sql.MyConnection;
import com.my.vo.Customer;

public class CustomerDAO {
	public void insert(Customer c) throws AddException {
		//1)DB연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MyConnection.getConnection();
		
			//2)SQL송신 		
			String insertSQL = 
			  "INSERT INTO customer(id, pwd, name, gender)"
			+ " VALUES (?,?,?,?)";
	    
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getPwd());
			pstmt.setString(3, c.getName());
			pstmt.setString(4, c.getGender());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getErrorCode() == 1) { //PK중복
				throw new AddException("이미 존재하는 ID입니다.");
			}
			throw new AddException(e.getMessage());
		} catch (Exception e) {			
			//e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
		    //3)DB연결해제
		    MyConnection.close(con, pstmt, null);
		}
	}
	
	public void update(Customer c) throws ModifyException{
		System.out.println(c);		
		Connection con = null;
		Statement stmt = null;
		try {
			con = MyConnection.getConnection();
			String updateSQL1 = "UPDATE customer SET ";
			String updateSQL2 =	" WHERE id='"+ c.getId() + "'";
			boolean flag = false;
			if(c.getPwd() != null) {
				updateSQL1 += "pwd='" + c.getPwd() + "'";
				flag = true;
			}
			if(c.getName() != null) {
				if(flag) {
					updateSQL1 += ",";
				}
				updateSQL1 += "name='" + c.getName() + "'";
				flag = true;
			}
			
			if(c.getGender() != null) {
				if(flag) {
					updateSQL1 += ",";
				}
				updateSQL1 += "gender='" + c.getGender() + "'";
				flag = true;
			}
			
			if(c.getReg_dt() != null) {
				if(flag) {
					updateSQL1 += ",";
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				String dt = sdf.format(c.getReg_dt());//날짜->문자열
				updateSQL1 += "reg_dt='" + dt + "'";
				flag = true;			
			}			
			
			if(c.getStatus() != 0) {
				if(flag) {
					updateSQL1 += ",";
				}
				updateSQL1 += "status=" + c.getStatus();
				flag = true;
			}
			
			if(flag) {
				stmt = con.createStatement();
				System.out.println(updateSQL1 + updateSQL2);
				stmt.executeUpdate(updateSQL1 + updateSQL2);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}finally {
			MyConnection.close(con, stmt, null);
		}
		
		
	}
	/**
	 * 아이디에 해당 고객을 검색하여 반환한다
	 * @param id 아이디
	 * @return 고객객체
	 * @throws NotFoundException 
	 *       DB연결실패이거나 아이디에 해당 고객이 없으면 예외발생한다
	 */
	public Customer selectById(String id) throws NotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			//2)SQL송신 		
			String selectByIdSQL = "SELECT * FROM customer WHERE id=?";
			pstmt = con.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				java.sql.Date reg_dt = rs.getDate("reg_dt");
				int status = rs.getInt("status");
				return new Customer(id, pwd, name, gender, reg_dt, status);
			}else {
				throw new NotFoundException("ID에 해당하는 고객이 없습니다");
			}
		} catch (Exception e) {					
			throw new NotFoundException("ID로 검색 오류:" + e.getMessage());
		} finally {
		    //3)DB연결해제
		    MyConnection.close(con, pstmt, rs);
		}
	}
	
	/**
	 * 이름에 해당단어를 포함한 고객들을 검색한다
	 * @param word 단어
	 * @return
	 * @throws NotFoundException
	 */
	public List<Customer> selectByName(String word) 
			throws NotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<>();
		try {
			con = MyConnection.getConnection();
			String selectByNameSQL = 
					"SELECT * FROM customer WHERE name LIKE ?";
			pstmt = con.prepareStatement(selectByNameSQL);
			pstmt.setString(1, "%" + word + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(
						new Customer(rs.getString("id")
								,rs.getString("pwd")
								,rs.getString("name")
								,rs.getString("gender")
								,rs.getDate("reg_dt")
								,rs.getInt("status")
								)
						);
			}
			if(list.size() == 0) {
				throw new NotFoundException(word+"에 해당하는 이름은 없습니다");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new NotFoundException("이름으로 검색오류:"+e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, rs);
		}
		return list;
	}
	public List<Customer> selectAll() throws NotFoundException{		
		Connection con = null;
		PreparedStatement pstmt = null;		ResultSet rs = null;
		List<Customer> list = new ArrayList<>();
		try {
			con = MyConnection.getConnection();
			String selectAllSQL = "SELECT * FROM customer ORDER BY id";
			pstmt = con.prepareStatement(selectAllSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");				    String pwd = rs.getString("pwd");
				String name = rs.getString("name");				String gender = rs.getString("gender");
				java.sql.Date reg_dt = rs.getDate("reg_dt");    int status = rs.getInt("status");
				list.add(new Customer(id, pwd, name, gender, reg_dt, status));
			}	
			if(list.size() == 0) {
				throw new NotFoundException("고객이 없습니다");
			}
			return list;
		} catch (Exception e) {			
			//e.printStackTrace();
			throw new NotFoundException("전체검색 오류:" + e.getMessage());
		} finally {		    
		    MyConnection.close(con, pstmt, rs);
		}
	
	}
}


