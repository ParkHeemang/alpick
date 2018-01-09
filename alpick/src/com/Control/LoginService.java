package com.Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Al_dictDAO;
import com.DAO.Al_infoDAO;
import com.DAO.MemberDAO;
import com.VO.Al_dictVO;
import com.VO.Al_infoVO;
import com.VO.MemberVO;
import com.google.gson.Gson;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDAO member_dao = MemberDAO.getInstance();

		try {
			int cnt = member_dao.login(id, pw);

			if (cnt > 0) {
				// 로그인이 성공하면 >> 술 정보, 도감 데이터도 같이 전송해야 함
				response.sendRedirect("LoginSuccess?id=" + id);
			} else {
				response.getWriter().print("-1");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
