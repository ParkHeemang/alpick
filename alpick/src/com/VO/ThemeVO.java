package com.VO;

public class ThemeVO {
	
	private String atmosphere;
	private String place;
	private String with_who;
	private String anniversary;
	private String product_no;
	
	
	
	public ThemeVO(String atmosphere, String place, String with_who, String anniversary, String product_no) {
	
		this.atmosphere = atmosphere;
		this.place = place;
		this.with_who = with_who;
		this.anniversary = anniversary;
		this.product_no = product_no;
	}
	public String getAtmosphere() {
		return atmosphere;
	}
	public String getPlace() {
		return place;
	}
	public String getWith_who() {
		return with_who;
	}
	public String getAnniversary() {
		return anniversary;
	}
	public String getProduct_no() {
		return product_no;
	}
	
	
	
	
	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setWith_who(String with_who) {
		this.with_who = with_who;
	}
	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
