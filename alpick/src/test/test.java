package test;

import com.DAO.Al_dictDAO;
import com.DAO.Al_infoDAO;
import com.DAO.MemberDAO;
import com.DAO.ThemeDAO;
import com.VO.Al_dictVO;
import com.VO.Al_infoVO;
import com.VO.MemberVO;
import com.VO.ThemeVO;

public class test {

	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();		
		Al_infoDAO al_infoDAO = new Al_infoDAO();
		Al_dictDAO al_dictDAO = new Al_dictDAO();
		ThemeDAO themeDAO = new ThemeDAO();
		
		//회원가입
		//memberDAO.join("park", "1234", "park", "2018-01-04", "AAAA"); 
		
		
		
		//id로 회원 정보 불러오기
		
		
		/*memberVO memberVO = memberDAO.idSelect("park");       
		
		String id = memberVO.getId();
		String pw = memberVO.getPw();
		String nickname = memberVO.getNickname();
		String user_type = memberVO.getUser_type();
		String year = memberVO.getYear();
		System.out.println("출력");
		System.out.println(id+"//"+pw+"//"+nickname+"//"+user_type+"//"+year);*/
		
		
		
		//술 info 추가
		//al_infoDAO.infoInsert("1", "1234567890123","참이슬","35","3500", "250");
		
		
		
		
		//술 dict추가
		//al_dictDAO.dictInsert("2", "kim","5");     //사전 row 추가 (product_no, memberid, score)
		
		
		//회원 id로 술 dict불러오기
		
		
		/*Al_dictVO al_dictVO = al_dictDAO.idSelect("park");
		
		int sequence_no = al_dictVO.getSequence_no();
		String product_no = al_dictVO.getProduct_no();
		String member_id = al_dictVO.getMember_id();
		String score = al_dictVO.getScore();
		String time = al_dictVO.getTime();
		
		System.out.println(sequence_no+"/"+product_no+"/"+member_id+"/"+score+"/"+time);*/
	
		
		
		
		
		//술info product_no(술 id)로 다른 정보 불러오기
		
		Al_infoVO al_infoVO = al_infoDAO.productIdSelect("01_0001");
		
		String product_no = al_infoVO.getProduct_no();
		String barcode  = al_infoVO.getBarcode();
		String product_name  = al_infoVO.getProduct_name();
		String alcohol  = al_infoVO.getAlcohol();
		String price  = al_infoVO.getPrice();
		String volume = al_infoVO.getVolume();
		
		
		System.out.println(product_no+"/"+barcode+"/"+product_name+"/"+alcohol+"/"+price+"/"+volume);
		
		
		
		
		
		
		//바코드(술 info)로 정보 불러오기
/*
		Al_infoVO al_infoVO = al_infoDAO.barcodeSelect("1234567890123");
		
		String product_no = al_infoVO.getProduct_no();
		String barcode  = al_infoVO.getBarcode();
		String product_name  = al_infoVO.getProduct_name();
		String alcohol  = al_infoVO.getAlcohol();
		String price  = al_infoVO.getPrice();
		String volume = al_infoVO.getVolume();
		
		
		System.out.println(product_no+"/"+barcode+"/"+product_name+"/"+alcohol+"/"+price+"/"+volume);
		
	*/
		
		
		/*
		//바코드를 찍는다(도감에 없는 경우)
		//바코드값으로 alcohol_info table을 불러온다
		String id = "park";
		String barcode = "0000000000001";
		
		
		Al_infoVO al_infoVO = al_infoDAO.barcodeSelect(barcode);
		String product_no = al_infoVO.getProduct_no();
		
		String score;
		score="4";
		
		if (score==null) {
			score="0";
		}
		
		al_dictDAO.dictInsert(product_no, id, score);
		
		
	*/
		
		
		
		
		
		
			
		
		
		
		
		
		
		/*
		//특히, product_no
		String alcoholID = al_infoVO.getProduct_no();
		
		
		//user의 id로 도감 테이블을 불러온다 , 여러개 나올텐데?
		
		
		
		Al_dictVO al_dictVO = al_dictDAO.idSelect("park");
				
				
				
		//
		
		//술의 고유 아이디로 
		
		*/
		
		
		
		
		
	/*	ThemeVO themeVO = null;
		
		themeVO = themeDAO.product_NoSelect("2");
		
		System.out.println(themeVO.getAtmosphere()+" / "+themeVO.getPlace());
		*/
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}
