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
import com.VO.Al_dictVO;
import com.VO.Al_infoVO;
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
		String info_result = null;
		String dic_result = null;

		Gson gson = null;

		Al_infoDAO info_dao = Al_infoDAO.getInstance();
		Al_dictDAO dic_dao = Al_dictDAO.getInstance();

		try {

			info_list = info_dao.selectAlInfo();
			dic_list = dic_dao.idSelect(id);

			if (info_list != null && dic_list != null) {

				gson = new Gson();

				String temp = null;
				
				for (int i = 0; i < info_list.size(); i++) {
					temp += gson.toJson(info_list.get(i));
				}

				info_result = gson.toJson(temp);

				temp = null;
				for (int i = 0; i < dic_list.size(); i++) {
					temp += gson.toJson(dic_list.get(i));
				}
				
				dic_result = gson.toJson(temp);
				
			} else if (info_list != null && dic_list == null) {
				
				gson = new Gson();

				String temp = null;

				for (int i = 0; i < info_list.size(); i++) {
					temp += gson.toJson(info_list.get(i));
				}

				info_result = gson.toJson(temp);
				dic_result = "";
				
			} else {
				info_result = "InfoDataError";
				dic_result = "DicDataError";
			}

			response.getWriter().print(info_result+" "+dic_result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
