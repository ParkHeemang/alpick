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

@WebServlet("/BarcodeSelection")
public class BarcodeSelection extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String barcode = request.getParameter("code");
		String score = request.getParameter("score");
		
		Al_infoDAO info_dao = Al_infoDAO.getInstance();
		Al_dictDAO dic_dao = Al_dictDAO.getInstance();
		Al_infoVO info_vo = null;
		ArrayList<Al_dictVO> dic_list = null;
		String dic_result = null;
		int cnt = 0;
		String sendmsg = null;
		
		Gson gson = null;
		
		info_vo = info_dao.barcodeSelect(barcode);
		
		if(info_vo != null) {
			
			cnt = dic_dao.dictInsert(info_vo.getProduct_no(), id, score);
			
			if (cnt > 0) {
				// 도감 정보 저장 성공 시
				dic_list = dic_dao.idSelect(id);
				
				gson = new Gson();
				
				dic_result = gson.toJson(dic_list);
			} else {
				// 도감 정보 저장 실패 시
				dic_result = "-1";
			}
			
		} else {
			sendmsg = "-1";
		}
		
		sendmsg += "1---"+dic_result;
		response.getWriter().print(sendmsg);
		
	}

}
