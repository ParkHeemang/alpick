package com.VO;

public class al_dictVO {
	
	private int sequence_no;
	private String product_no;
	private String member_id;
	private String score;
	private String time;
	
	
	public al_dictVO(int sequence_no, String product_no, String member_id, String score, String time) {
		
		this.sequence_no = sequence_no;
		this.product_no = product_no;
		this.member_id = member_id;
		this.score = "0";
		this.time = time;
	}


	public int getSequence_no() {
		return sequence_no;
	}


	public String getProduct_no() {
		return product_no;
	}


	public String getMember_id() {
		return member_id;
	}


	public String getScore() {
		return score;
	}


	public String getTime() {
		return time;
	}


	public void setSequence_no(int sequence_no) {
		this.sequence_no = sequence_no;
	}


	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	

}
