package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Drugstore;

public class DrugstoreDao {

	private final static String TAG = "DrugstoreDao";
	
	// 싱글톤
	private static DrugstoreDao instance = new DrugstoreDao();
	// 프로그램 실행 시 처음에 바로 뜨고 한번만 만들어짐 
	
	
	public static DrugstoreDao getInstance() {
		return instance;
	}
	
	// 생성자
	public DrugstoreDao() {
		
	}
	
	// 처음 줄만 받아오기
	public Drugstore getFirstLine() { 
		String SQL = "SELECT * FROM drugstore";
		Connection conn = null; // 선언만 해도 문제는 없지만 null로 하는 것이 안전
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Drugstore ds = null; // 우리가 가져올 데이터
		
		// DB 연결문
		try {
			conn = DBConnection.getConnection(); // DB에 연결
			pstmt = conn.prepareStatement(SQL); // SQL 워크시트가 뜬 상태 (쿼리문을 넣은 상태)
			rs = pstmt.executeQuery(); // SQL 워크시트에서 결과값을 가지고 오기 (?가 없기때문에 기본상태)
			
			// 다음라인 읽기 (next()는 boolean형태)
			if(rs.next()) {
				ds = new Drugstore(rs.getString(1), rs.getString(2));
			}
			return ds; // ds값을 return 해주기 / return은 함수를 종료시킨다.
			
		} catch (Exception e) {
			System.out.println(TAG + e.getMessage());
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(DrugstoreDao.getInstance().getFirstLine());
	}
}