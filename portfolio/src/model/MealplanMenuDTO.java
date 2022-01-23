package model;

public class MealplanMenuDTO {
	private String menuNo;
	private String deliveryNo;
	private String mealkitNo;
	
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public void setMealkitNo(String mealkitNo) {
		this.mealkitNo = mealkitNo;
	}
	
	public String getMenuNo() {
		return menuNo;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public String getMealkitNo() {
		return mealkitNo;
	}
	
}
