package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.NotFoundException;
import com.my.sql.MyConnection;
import com.my.vo.Product;

public class ProductDAO {
	/**
	 * 상품번호로 상품객체를 검색한다
	 * @param prod_no 상품번호
	 * @return 상품객체
	 * @throws NotFoundException 상품을 찾지못하면 NotFoundException발생한다
	 */
	public Product selectByNo(String prod_no) throws NotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			String selectByNoSQL = "SELECT * FROM product WHERE prod_no=?";
			pstmt = con.prepareStatement(selectByNoSQL);
			pstmt.setString(1, prod_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Product p = new Product();
				p.setProd_no(rs.getString("prod_no"));
				p.setProd_name(rs.getString("prod_name"));
				p.setProd_price(rs.getInt("prod_price"));
				return p;
			}else {
				throw new NotFoundException("번호에 해당하는 상품이 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}finally {
			MyConnection.close(con, pstmt, rs);
		}
	}
	/**
	 * 상품명에 해당단어를 포함한 상품들을 검색한다
	 * @param word 단어
	 * @return
	 * @throws NotFoundException
	 */
	public List<Product> selectByName(String word) throws NotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		try {
			con = MyConnection.getConnection();
			String selectByNameSQL = "SELECT * FROM product WHERE prod_name LIKE ?";
			pstmt = con.prepareStatement(selectByNameSQL);
			pstmt.setString(1, "%"+word+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString("prod_no")
						,rs.getString("prod_name")
						,rs.getInt("prod_price")
						)
						);
			}
			if(list.size()==0) {
				throw new NotFoundException("상품명에 해당하는 상품이 없습니다.");
			}
		}catch (Exception e) {
			//e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}finally {
			MyConnection.close(con, pstmt, rs);
		}
		return list;
	}
	public List<Product> selectAll() throws NotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		try {
			con = MyConnection.getConnection();
			String selecAllSQL = "SELECT * FROM product";
			pstmt = con.prepareStatement(selecAllSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString("prod_no")
						,rs.getString("prod_name")
						,rs.getInt("prod_price")
						)
						);
			}
			if(list.size()==0) {
				throw new NotFoundException("상품이 없습니다.");
			}		
		}catch (Exception e) {
				//e.printStackTrace();
				throw new NotFoundException(e.getMessage());
		}finally {
			MyConnection.close(con, pstmt, rs);
		}
		return list;
	}		
}
