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

		System.out.println(id);
		System.out.println(pw);

		MemberDAO member_dao = MemberDAO.getInstance();

		try {
			int cnt = member_dao.login(id, pw);

			if (cnt > 0) {
				// �α����� �����ϸ� >> �� ����, ���� �����͵� ���� �����ؾ� ��
				response.sendRedirect("LoginSuccess?id=" + id);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
