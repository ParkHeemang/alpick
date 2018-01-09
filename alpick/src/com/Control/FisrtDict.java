package com.Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Al_dictDAO;
import com.DAO.MemberDAO;
import com.VO.Al_dictVO;
import com.VO.MemberVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/FisrtDict")
public class FisrtDict extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		String id = request.getParameter("id");
		ArrayList<Al_dictVO> dic_list = gson.fromJson(request.getParameter("dic_list"), new TypeToken<ArrayList<Al_dictVO>>() {}.getType());
		ArrayList<Al_dictVO> dic_response = null;
		MemberDAO mem_dao = MemberDAO.getInstance();
		MemberVO mvo = null;
		String dic_temp = null;
		String mem_temp = null;
		
		Al_dictDAO dic_dao = Al_dictDAO.getInstance();
		String result = "0";
		
		if(dic_list != null) {
			// 회원가입 후 처음으로 평점 매긴 데이터를 받았을 때
			for (int i = 0; i < dic_list.size(); i++) {
				dic_dao.dictInsert(dic_list.get(i).getProduct_no(), id, dic_list.get(i).getScore());
			}
			
			mvo = mem_dao.idSelect(id);
			mem_temp = gson.toJson(mvo);
			dic_response = dic_dao.idSelect(id);
			dic_temp = gson.toJson(dic_response);
			
			result = "1";
		} else {
			// 회원가입 후 평점 매긴 데이터를 보내지 않았을 때
			result = "-1";
		}
		
		response.getWriter().print(result+"---"+dic_temp+"---"+mem_temp);
		
	}

}
