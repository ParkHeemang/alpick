package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VO.MemberVO;
import com.VO.ThemeVO;

public class ThemeDAO {
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void getConn() {
		/* DB�����ϴ� �ڵ� */

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
		/* DB���� �����ϴ� �ڵ� */

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
	
	// product_no�� �׸����� ��������
		public ThemeVO product_NoSelect(String product_no) { // ������ ���ٸ� null ����

			getConn();
			String sql = "select * from theme where product_no=?";
			ThemeVO themeVO = null;

			try {

				pst = conn.prepareStatement(sql);
				pst.setString(1, product_no);
				rs = pst.executeQuery();

				if (rs.next()) { // ������� ��������

					String atmosphere = rs.getString(1);
					String place = rs.getString(2);
					String with_who = rs.getString(3);
					String anniversary = rs.getString(4);
					themeVO = new ThemeVO(atmosphere, place, with_who, anniversary,product_no);

				} else {
					System.out.println("memberDAO�� idselect �̰� �߸� id�� �˻��� ��� ���°��ΰ�");
					return null;
				}

			} catch (SQLException e) {
				System.out.println("memberDAO emailselect error");
				e.printStackTrace();
			}

			close();
			return themeVO;

		}
	
	
		
		
		
	
	
	
	
	
	
	

}
