package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Al_infoDAO {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void getConn() {


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
	
	
	
	
	public int infoInsert(String product_no, String barcode, String product_name, String alcohol, String price, String volume) {
		getConn();
		String sql = "insert into al_info values(?,?,?,?,?,?)";
		int cnt = -1;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, product_no);
			pst.setString(2, barcode);
			pst.setString(3, product_name);
			pst.setString(4, alcohol);
			pst.setString(5, price);
			pst.setString(6, volume);
			

			cnt = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("al_dictDAO join error");
			e.printStackTrace();
		}
		close();
		return cnt;
	}

}
