package com.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.VO.memberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void getConn() {

		/*
		 * InputStream in =
		 * (this.getClass().getResourceAsStream("../../../../db.properties"));
		 * Properties p = new Properties(); try {
		 * 
		 * System.out.println(p); p.load(in); } catch (IOException e1) {
		 * System.out.println("memberDAO getConn properties errer");
		 * e1.printStackTrace(); }
		 */

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

	// ȸ������
	public int join(String id, String pw, String nickname, String year, String user_type) {
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

	// ���̵�� �������� ��������
	public memberVO idSelect(String id) { // ������ ���ٸ� null ����
		getConn();
		String sql = "select * from users where id=?";
		memberVO mvo = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) { // ������� ��������
				String pw = rs.getString(2);
				String nickname = rs.getString(3);
				String year = rs.getString(4);
				String user_type = rs.getString(5);
				mvo = new memberVO(id, pw, nickname, year, user_type);
			} else {
				System.out.println("memberDAO�� idselect �̰� �߸� id�� �˻��� ��� ���°��ΰ�");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("memberDAO emailselect error");
			e.printStackTrace();
		}
		close();
		return mvo;
	}

	public int updateUser_type(String id, String user_type) {
		// ���� ���̵�� �������� ����
		getConn();
		int cnt = -1;
		try {
			String sql = "select id from users where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id); // ����ǥ ����ֱ�
			rs = pst.executeQuery();

			if (rs.next()) { // �˻����� ������
				String sql2 = "update users set user_type=? where id=?";

				pst = conn.prepareStatement(sql2);
				pst.setString(1, user_type);
				pst.setString(2, id);

				cnt = pst.executeUpdate();
			} // �˻��� ������ -1 return

			System.out.println(id + "�� user_type " + user_type + "���� ���� �Ϸ�");
			System.out.println("cnt��:" + cnt);
		} catch (SQLException e) {
			System.out.println("memberDAO updateFavorite error");
			e.printStackTrace();
		}
		close();
		return cnt;
	}

}
