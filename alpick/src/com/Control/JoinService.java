package com.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;
import com.VO.MemberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "ask";
		String pw = "ask123";
		String nickname = "ksa";
		String year = "123456";
		
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			int cnt = dao.join(id, pw, nickname, year);
			
			if(cnt > 0) {
				response.sendRedirect("main/main.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
