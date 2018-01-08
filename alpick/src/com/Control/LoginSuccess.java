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

		String id = request.getParameter("id");
		
		ArrayList<Al_infoVO> info_list = null;
		ArrayList<Al_dictVO> dic_list = null;

		Gson gson = null;

		Al_infoDAO info_dao = Al_infoDAO.getInstance();
		Al_dictDAO dic_dao = Al_dictDAO.getInstance();

		try {

			info_list = info_dao.selectAlInfo();
			dic_list = dic_dao.idSelect(id);

			if (info_list != null && dic_list != null) {

				gson = new Gson();

				String result = null;

				for (int i = 0; i < info_list.size(); i++) {
					// result += gson.toJson(info_list.get(i).getProduct_no(),
					// info_list.get(i).getBarcode());
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
