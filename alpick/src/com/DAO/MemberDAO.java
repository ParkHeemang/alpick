package com.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.VO.MemberVO;

public class MemberDAO {
	/* USERS테이블에 접근하는 클래스 */
	
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		// MemberDAO 인스턴스
		return instance;
	}

	public void getConn() {
		/* DB연결하는 메소드 */

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "smart4";
		String dbpw = "smart4";

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
		/* DB연결 해제하는 코드 */

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

	// 회원가입
	public int join(String id, String pw, String nickname, String year) {

		getConn();
		String sql = "insert into users values(?,?,?,?,'0')";
		int cnt = -1;

		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, nickname);
			pst.setString(4, year);

			cnt = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("memberDAO join error");
			e.printStackTrace();
		}

		close();
		return cnt;
	}

	public int login(String input_id, String input_pw) {
		/* login판별 코드 */

		getConn();
		String sql = "select * from users where id=? and pw=?";
		int cnt = -1;
		
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, input_id);
			pst.setString(2, input_pw);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				cnt = 1;
			} else {
				cnt = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	// 아이디로 다른정보 가져오기
	public MemberVO idSelect(String id) { // 정보가 없다면 null 리턴

		getConn();
		String sql = "select * from users where id=?";
		MemberVO mvo = null;

		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) { // 결과값이 있으면은

				String pw = rs.getString(2);
				String nickname = rs.getString(3);
				String year = rs.getString(4);
				String user_type = rs.getString(5);
				mvo = new MemberVO(id, pw, nickname, year, user_type);

			} else {
				System.out.println("memberDAO의 idselect 이게 뜨면 id로 검색한 결과 없는것인것");
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
		// 유저 아이디로 유저성향 변경

		getConn();
		int cnt = -1;

		try {

			String sql = "select id from users where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id); // 물음표 집어넣기
			rs = pst.executeQuery();

			if (rs.next()) { // 검색값이 있으면
				String sql2 = "update users set user_type=? where id=?";

				pst = conn.prepareStatement(sql2);
				pst.setString(1, user_type);
				pst.setString(2, id);

				cnt = pst.executeUpdate();

			} // 검색값 없으면 -1 return

			System.out.println(id + "의 user_type " + user_type + "으로 변경 완료");
			System.out.println("cnt값:" + cnt);

		} catch (SQLException e) {
			System.out.println("memberDAO updateFavorite error");
			e.printStackTrace();
		}

		close();
		return cnt;

	}

}