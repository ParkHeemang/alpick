package test;

import com.DAO.MemberDAO;
import com.VO.memberVO;

public class test {

	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
		
//		memberDAO.join("park3", "1234", "park3", "2018-01-04", "AAAA");
		
		/*memberVO memberVO = memberDAO.idSelect("park3");
		
		String id = memberVO.getId();
		String pw = memberVO.getPw();
		String nickname = memberVO.getNickname();
		String user_type = memberVO.getUser_type();
		String year = memberVO.getYear();
		
		System.out.println("Ãâ·Â");
		System.out.println(id+"//"+pw+"//"+nickname+"//"+user_type+"//"+year);
		*/
		
		memberDAO.updateUser_type("park3", "BBBB");
		
		
	}

	
}
