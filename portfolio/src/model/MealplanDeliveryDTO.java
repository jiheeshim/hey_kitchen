package model;

public class MealplanDeliveryDTO {

	private String deliveryNo;
	private String mealplanNo;
	private String postcode;
	private String addr1;
	private String extraAddr;
	private String addr2;
	private String deliverDate;
	
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public void setMealplanNo(String mealplanNo) {
		this.mealplanNo = mealplanNo;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public void setExtraAddr(String extraAddr) {
		this.extraAddr = extraAddr;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public String getMealplanNo() {
		return mealplanNo;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public String getExtraAddr() {
		return extraAddr;
	}
	public String getAddr2() {
		return addr2;
	}
	public String getDeliverDate() {
		return deliverDate;
	}
	
}
