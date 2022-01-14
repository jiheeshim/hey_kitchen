package model;

public class MealplanMenuDTO {
	private String menuNo;
	private String mealplanNo;
	private String mealkitNo;
	
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public void setMealplanNo(String mealplanNo) {
		this.mealplanNo = mealplanNo;
	}
	public void setMealkitNo(String mealkitNo) {
		this.mealkitNo = mealkitNo;
	}
	
	public String getMenuNo() {
		return menuNo;
	}
	public String getMealplanNo() {
		return mealplanNo;
	}
	public String getMealkitNo() {
		return mealkitNo;
	}
	
}
