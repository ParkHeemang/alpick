package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VO.Al_dictVO;
import com.VO.Al_infoVO;

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
	
	
	public Al_infoVO productIdSelect(String product_no) { // 정보가 없다면 null 리턴
		getConn();
		String sql = "select * from al_info where product_no=?";
		Al_infoVO al_infoVO = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, product_no);
			rs = pst.executeQuery();

			if (rs.next()) { // 결과값이 있으면은
				String barcode = rs.getString(2);
				String product_name = rs.getString(3);
				String alcohol = rs.getString(4);
				String price = rs.getString(5);
				String volume = rs.getString(6);
				
				al_infoVO = new Al_infoVO(product_no,barcode, product_name, alcohol, price, volume);
			} else {
				System.out.println("memberDAO의 idselect 이게 뜨면 id로 검색한 결과 없는것인것");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("memberDAO emailselect error");
			e.printStackTrace();
		}
		close();
		return al_infoVO;
	}
	
	
	
	public Al_infoVO barcodeSelect(String barcode) { // 정보가 없다면 null 리턴
		getConn();
		String sql = "select * from al_info where barcode=?";
		Al_infoVO al_infoVO = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, barcode);
			rs = pst.executeQuery();

			if (rs.next()) { // 결과값이 있으면은
				String product_no = rs.getString(1);
				String product_name = rs.getString(3);
				String alcohol = rs.getString(4);
				String price = rs.getString(5);
				String volume = rs.getString(6);
				
				al_infoVO = new Al_infoVO(product_no,barcode, product_name, alcohol, price, volume);
			} else {
				System.out.println("memberDAO의 idselect 이게 뜨면 id로 검색한 결과 없는것인것");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("memberDAO emailselect error");
			e.printStackTrace();
		}
		close();
		return al_infoVO;
	}
	
	
	
	
	
	
	
	
	

}
