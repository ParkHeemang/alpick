package com.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MemberDAO;
import com.VO.MemberVO;
import com.google.gson.Gson;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		String year = request.getParameter("year");

		MemberDAO dao = MemberDAO.getInstance();

		try {
			int cnt = dao.join(id, pw, nickname, year);

			if (cnt > 0) {
				
				Gson gson = new Gson();
				
				String result = gson.toJson("1");
				
				response.getWriter().print(result);
			} else {
				response.getWriter().print("-1");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
