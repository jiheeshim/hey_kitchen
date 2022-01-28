package model;

public class MealplanDTO {
	private String mealplanNo;
	private String id;
	private int serving;
	private int servingCnt;
	private String subDate;
	private String cancelDate;
	private int subPrice;
	
	public void setMealplanNo(String mealplanNo) {
		this.mealplanNo = mealplanNo;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setServing(int serving) {
		this.serving = serving;
	}
	public void setServingCnt(int servingCnt) {
		this.servingCnt = servingCnt;
	}
	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}
	public void setSubPrice(int subPrice) {
		this.subPrice = subPrice;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	public String getMealplanNo() {
		return mealplanNo;
	}
	public String getId() {
		return id;
	}
	public int getServing() {
		return serving;
	}
	public int getServingCnt() {
		return servingCnt;
	}
	public String getSubDate() {
		return subDate;
	}
	public int getSubPrice() {
		return subPrice;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	
}
