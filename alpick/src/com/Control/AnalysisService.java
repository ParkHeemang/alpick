package com.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/AnalysisService")
public class AnalysisService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		
		String id = request.getParameter("id");
		String user_type = request.getParameter("user_type");
		String result = null;
		
		Analysis ana = new Analysis();
		
		StringBuffer temp = ana.analysis(id, user_type);
		
		if(result.toString().equals("")) {
			/* �м� ��� ���� �� */
			response.getWriter().print("-1");
		} else {
			/* �м� ��� ���� �� */
			
			Gson gson = new Gson();
			
			result = gson.toJson(temp);
			
			response.getWriter().print("1---"+result);
		}
		
	}

}
