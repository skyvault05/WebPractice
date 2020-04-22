package ex0416.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0416.domain.Member;
import ex0416.util.DbUtil;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insert(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO member(id, pwd, name, age, phone, addr, join_date) VALUES (?,?,?,?,?,?, SYSDATE)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getAddr());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public boolean idCheck(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "SELECT * FROM member WHERE lower(id) = lower(?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id.trim());
			rs = ps.executeQuery();
			if(rs.next())result=true;
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public List<Member> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		List<Member> list = new ArrayList<>();
		String sql = "SELECT id, pwd, name, age, phone, addr, join_date FROM member";
		
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 갯수만큼 setXXX가 필요함(여긴없음)
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age"), rs.getString("phone"), rs.getString("addr"), rs.getString("join_date"));
				list.add(member);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public Member selectById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "SELECT id, pwd, name, age, phone, addr, join_date FROM member WHERE id=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();	
			
			if(rs.next()) {
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			
			return member;
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
	}

	@Override
	public List<Member> searchByKeyword(String keyField, String keyword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<>();
		String sql = "SELECT id, pwd, name, age, phone, addr, join_date FROM member ";
		
		
		try {
			if(keyField.equals("id")) {
				sql+="WHERE LOWER(id) LIKE LOWER(?)";
			}else if(keyField.equals("addr")) {
				sql+="WHERE LOWER(addr) LIKE LOWER(?)";
			}else if (keyField.equals("name")) {
				sql+="WHERE LOWER(name) LIKE LOWER(?)";
			}
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword.trim()+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Member member = new Member(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age"), rs.getString("phone"), rs.getString("addr"), rs.getString("join_date"));
				list.add(member);
			}
			return list;
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
	}

	@Override
	public int delete(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM member WHERE id = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
