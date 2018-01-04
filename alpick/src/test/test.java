package test;

import com.DAO.memberDAO;

public class test {

	public static void main(String[] args) {
		
		memberDAO memberDAO = new memberDAO();
		
		memberDAO.join("park1", "1234", "park1", "2018-01-04", "AAAA");
		
		
	}

}
