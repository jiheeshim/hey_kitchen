package model;

public class MealplanManageDTO {
	
	private String mealplanNo;
	private String subDate;
	private int serving;
	private int servingCnt;
	private int price;
	private String deliveryNo;
	private String deliverDate;
	private String postcode;
	private String addr1;
	private String extraAddr;
	private String addr2;
	
	public void setMealplanNo(String mealplanNo) {
		this.mealplanNo = mealplanNo;
	}
	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}
	public void setServing(int serving) {
		this.serving = serving;
	}
	public void setServingCnt(int servingCnt) {
		this.servingCnt = servingCnt;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
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
	
	public String getMealplanNo() {
		return mealplanNo;
	}
	public String getSubDate() {
		return subDate;
	}
	public int getServing() {
		return serving;
	}
	public int getServingCnt() {
		return servingCnt;
	}
	public int getPrice() {
		return price;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public String getDeliverDate() {
		return deliverDate;
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
	
}
