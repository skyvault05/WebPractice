package kosta.mvc.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.domain.Electronics;
import kosta.mvc.util.DbUtil;

public class ElectronicsDAOImpl implements ElectronicsDAO {
	Properties pro = new Properties();
	public ElectronicsDAOImpl() {
		//sqlQuery.properties파일을 로딩하기
		InputStream input = getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Electronics> selectAll() throws SQLException {
		Connection con = null;
		String sql = pro.getProperty("list");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Electronics> list = new ArrayList<>();
		
		try {
			con = DbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			Electronics electronics = new Electronics(rs.getString("model_num"), rs.getString("model_name"), rs.getInt("price"),
					rs.getString("description"), rs.getString("password"), rs.getString("writeday"), rs.getInt("readnum"), rs.getString("fname"), rs.getInt("fsize"));
			list.add(electronics);
		}
		return list;
		}finally {
			DbUtil.dbClose(con, pstmt, rs);
		}
		
	}

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		Connection con = null;
		String sql = pro.getProperty("selectByModelNum");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Electronics electronics = null;
		
		try {
			con = DbUtil.getConnection();
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, modelNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				electronics = new Electronics(rs.getString("model_num"), rs.getString("model_name"), rs.getInt("price"),
						rs.getString("description"), rs.getString("password"), rs.getString("writeday"), rs.getInt("readnum"), rs.getString("fname"), rs.getInt("fsize"));
			}
		}finally {
			DbUtil.dbClose(con, pstmt, rs);
		}
		return electronics;
	}

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = pro.getProperty("increamentByReadnum");
		int result =0;
		
		try {
			con = DbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modelNum);
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		Connection con = null;
		String sql = pro.getProperty("insert");
		PreparedStatement pstmt = null;
		int result=0;
		
		try {
			con = DbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, electronics.getModelNum());
			pstmt.setString(2, electronics.getModelName());
			pstmt.setInt(3, electronics.getPrice());
			pstmt.setString(4, electronics.getDescription());
			pstmt.setString(5, electronics.getPassword());
			pstmt.setString(6, electronics.getFname());
			pstmt.setInt(7, electronics.getFsize());
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = pro.getProperty("delete");
		
		try {
			con=DbUtil.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, modelNum);
			pstmt.setString(2, password);
			
			result = pstmt.executeUpdate();			
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		Connection con = null;
		String sql = pro.getProperty("update");
		PreparedStatement pstmt = null;
		int result=0;
		
		try {
			con = DbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, electronics.getModelName());
			pstmt.setInt(2, electronics.getPrice());
			pstmt.setString(3, electronics.getDescription());
			pstmt.setString(4, electronics.getModelNum());
			pstmt.setString(5, electronics.getPassword());
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

}
