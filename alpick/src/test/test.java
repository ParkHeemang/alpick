package test;

import com.DAO.Al_dictDAO;
import com.DAO.Al_infoDAO;
import com.DAO.MemberDAO;
import com.VO.Al_dictVO;
import com.VO.Al_infoVO;
import com.VO.MemberVO;

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
		
		//al_dictDAO.dictInsert("2", "kim","5");             //사전 row 추가 (product_no, memberid, score)
		
		
		/*Al_dictVO al_dictVO = al_dictDAO.idSelect("park");
		
		int sequence_no = al_dictVO.getSequence_no();
		String product_no = al_dictVO.getProduct_no();
		String member_id = al_dictVO.getMember_id();
		String score = al_dictVO.getScore();
		String time = al_dictVO.getTime();
		
		System.out.println(sequence_no+"/"+product_no+"/"+member_id+"/"+score+"/"+time);*/
	
		
		
		
		
		
/*		Al_infoVO al_infoVO = al_infoDAO.productIdSelect("1");
		
		String product_no = al_infoVO.getProduct_no();
		String barcode  = al_infoVO.getBarcode();
		String product_name  = al_infoVO.getProduct_name();
		String alcohol  = al_infoVO.getAlcohol();
		String price  = al_infoVO.getPrice();
		String volume = al_infoVO.getVolume();
		
		
		System.out.println(product_no+"/"+barcode+"/"+product_name+"/"+alcohol+"/"+price+"/"+volume);*/
		
		
		
		
		
		
		
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
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//특히, product_no
		String alcoholID = al_infoVO.getProduct_no();
		
		
		//user의 id로 도감 테이블을 불러온다 , 여러개 나올텐데?
		
		
		
		Al_dictVO al_dictVO = al_dictDAO.idSelect("park");
				
				
				
		//
		
		//술의 고유 아이디로 
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}
