package com.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");

		String id = request.getParameter("id");
		String user_type = request.getParameter("user_type");

		MemberDAO dao = MemberDAO.getInstance();

		try {
			int cnt = dao.updateUser_type(id, user_type);
			
			if(cnt > 0) {
				// ������Ʈ ���� ��
				response.getWriter().print("1");
				
			} else {
				// ������Ʈ ���� ��
				response.getWriter().print("-1");
				
			}
			
		} catch (Exception e) {
			
		}
	}

}
