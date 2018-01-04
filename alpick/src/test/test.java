package test;

import com.DAO.Al_dictDAO;
import com.DAO.Al_infoDAO;
import com.DAO.MemberDAO;
import com.VO.memberVO;

public class test {

	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();		
		Al_infoDAO al_infoDAO = new Al_infoDAO();
		Al_dictDAO al_dictDAO = new Al_dictDAO();
		
		
		//memberDAO.join("park", "1234", "park", "2018-01-04", "AAAA");  //회원가입
		
		
		
		
		/*memberVO memberVO = memberDAO.idSelect("park");       //회원 정보 불러오기
		
		String id = memberVO.getId();
		String pw = memberVO.getPw();
		String nickname = memberVO.getNickname();
		String user_type = memberVO.getUser_type();
		String year = memberVO.getYear();
		System.out.println("출력");
		System.out.println(id+"//"+pw+"//"+nickname+"//"+user_type+"//"+year);*/
		
		
		//al_infoDAO.infoInsert("1", "1234567890123","참이슬","35","3500", "250");
		
		al_dictDAO.dictInsert("2", "kim","5");             //사전 row 추가 (product_no, memberid, score)
		
		
		
	}

	
}
