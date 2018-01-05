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
				// �α����� �����ϸ� >> �� ����, ���� �����͵� ���� �����ؾ� ��
				response.sendRedirect("LoginSuccess?id="+id);
			} else {
				// �α����� �����ϸ� >> �ٽ� �α��� â���� ���� ��
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
