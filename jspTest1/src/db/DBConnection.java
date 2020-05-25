package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	// 디비 연결
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cos", "bitc5600");
			return conn;
		} catch (Exception e) {
			System.out.println("디비연결에러 : " + e.getMessage());
		}
		return null;
	}
	
	
	// 디비종료
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conn != null) { //객체가 null 일때 받으려고 하면 프로그램이 종료되기 때문에 null이 아닐경우에만 받는 조건문
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
			
		} catch (Exception e) {
			System.out.println("디비종료에러 : " + e.getMessage());
		}
	}
	
}
