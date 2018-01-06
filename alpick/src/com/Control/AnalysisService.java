package com.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AnalysisService")
public class AnalysisService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String user_type = request.getParameter("user_type");
		
		Analysis ana = new Analysis();
		
		StringBuffer result = ana.analysis(id, user_type);
		
		if(result.toString().equals("")) {
			/* 분석 결과 실패 시 */
			
		} else {
			/* 분석 결과 성공 시 */
		}
		
	}

}
