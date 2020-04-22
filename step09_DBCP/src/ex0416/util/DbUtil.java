package ex0416.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



/**
 * DB연동에 관련된 로드, 연결, 닫기 기능 담당할 클래스
 * @author hyo-jinkim
 */
public class DbUtil {
	private static DataSource dataSource;
	/**
	 * 로드
	 */
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/myoracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 연결
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
		
	}
	
	
	/**
	 * 닫기 (DML전용 : insert, update, delete)
	 * @throws SQLException 
	 */
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st!=null)st.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 닫기
	 */
	
	public static void dbClose(Connection con, Statement st, ResultSet rs) {		
		try {
			if(rs!=null)rs.close();
			dbClose(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
