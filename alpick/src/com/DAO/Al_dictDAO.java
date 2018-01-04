package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VO.Al_dictVO;
import com.VO.MemberVO;

public class Al_dictDAO {
	
	
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
	
	
	
	
	public int dictInsert(String product_no, String member_id, String score) {
		getConn();
		String sql = "insert into al_dict values(sequence_no.nextval,?,?,?,to_char(sysdate, 'YYYY-MM-DD'))";
		int cnt = -1;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, product_no);
			pst.setString(2, member_id);
			pst.setString(3, score);
			

			cnt = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("al_dictDAO join error");
			e.printStackTrace();
		}
		close();
		return cnt;
	}
	
	// 아이디로 다른정보 가져오기
		public Al_dictVO idSelect(String member_id) { // 정보가 없다면 null 리턴
			getConn();
			String sql = "select * from al_dict where member_id=?";
			Al_dictVO al_dictVO = null;

			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, member_id);
				rs = pst.executeQuery();

				if (rs.next()) { // 결과값이 있으면은
					int sequence_no = rs.getInt(1);
					String product_no = rs.getString(2);
					String score = rs.getString(4);
					String time = rs.getString(5);
					
					al_dictVO = new Al_dictVO(sequence_no, product_no, member_id, score, time);
				} else {
					System.out.println("memberDAO의 idselect 이게 뜨면 id로 검색한 결과 없는것인것");
					return null;
				}
			} catch (SQLException e) {
				System.out.println("memberDAO emailselect error");
				e.printStackTrace();
			}
			close();
			return al_dictVO;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
