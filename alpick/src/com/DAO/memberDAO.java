package com.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class memberDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	public void getConn() {
		
		/*InputStream in = (this.getClass().getResourceAsStream("../../../../db.properties"));
		Properties p = new Properties();
		try {
			
			System.out.println(p);
			p.load(in);
		} catch (IOException e1) {
			System.out.println("memberDAO getConn properties errer");
			e1.printStackTrace();
		}*/
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "wcadmin";
		String dbpw = "wcadmin";
		
		
		
				

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("memberDAO forName error");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (SQLException e) {
			System.out.println("memberDAO connection error");
			e.printStackTrace();
		}
		
		
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("memberDAO close finally error");
			e.printStackTrace();
		}
	}
	
	
	//회원가입
		public int join(String id, String pw, String nickname,String year, String user_type) {
			getConn();
			String sql = "insert into users values(?,?,?,?,?)";
			int cnt = -1;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2, pw);
				pst.setString(3, nickname);
				pst.setString(4, year);
				pst.setString(5, user_type);
				
				cnt = pst.executeUpdate();
				
				
				
			} catch (SQLException e) {
				System.out.println("memberDAO join error");
				e.printStackTrace();
			}
			close();
			return cnt;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
