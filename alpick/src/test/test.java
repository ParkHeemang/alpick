package test;

import com.DAO.memberDAO;

public class test {

	public static void main(String[] args) {
		
		memberDAO memberDAO = new memberDAO();
		
		memberDAO.join("park3", "1234", "park3", "2018-01-04", "AAAA");
		
		
	}

	
}
