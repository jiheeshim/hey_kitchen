package model;

public class MealplanPriceDTO {
	private int servingCnt;
	private int price;
	
	public void setServingCnt(int servingCnt) {
		this.servingCnt = servingCnt;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getServingCnt() {
		return servingCnt;
	}
	public int getPrice() {
		return price;
	}
	
}
