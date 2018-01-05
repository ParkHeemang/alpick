package com.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;
import com.VO.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			int cnt = dao.login(id, pw);
			
			
			if(cnt == 1) {
				// 로그인이 성공하면 >> 술 정보, 도감 데이터도 같이 전송해야 함
				response.sendRedirect("LoginSuccess?id="+id);
			} else {
				// 로그인이 실패하면 >> 다시 로그인 창으로 가야 함
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
