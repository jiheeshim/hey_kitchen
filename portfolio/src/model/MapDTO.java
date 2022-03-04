package model;

public class MapDTO {
	
	private int mapNo;
	private String title;
	private double ma;
	private double la;
	private String address;
	
	public void setMapNo(int mapNo) {
		this.mapNo = mapNo;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMa(double ma) {
		this.ma = ma;
	}
	public void setLa(double la) {
		this.la = la;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getMapNo() {
		return mapNo;
	}
	public String getTitle() {
		return title;
	}
	public double getMa() {
		return ma;
	}
	public double getLa() {
		return la;
	}
	public String getAddress() {
		return address;
	}
	

}
