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

@WebServlet("/LoginSuccess")
public class LoginSuccess extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");

		String id = request.getParameter("id");

		ArrayList<Al_infoVO> info_list = null;
		ArrayList<Al_dictVO> dic_list = null;
		MemberVO mvo = null;
		String info_result = null;
		String dic_result = null;

		Gson gson = null;

		Al_infoDAO info_dao = Al_infoDAO.getInstance();
		Al_dictDAO dic_dao = Al_dictDAO.getInstance();
		MemberDAO mem_dao = MemberDAO.getInstance();
		
		String nick = null;

		try {
			
			info_list = info_dao.selectAlInfo();
			dic_list = dic_dao.idSelect(id);
			mvo = mem_dao.idSelect(id);

			if (info_list != null && dic_list != null) {

				gson = new Gson();

				info_result = gson.toJson(info_list);
				dic_result = gson.toJson(dic_list);

			} else if (info_list != null && dic_list == null) {

				gson = new Gson();

			} else {
				info_result = "Data1Error";
				dic_result = "Data2Error";
			}

			
			System.out.println(info_result);
			System.out.println(dic_result);
			
			response.getWriter().print("1---"+info_result+"---"+dic_result+"---"+mvo.getNickname());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
