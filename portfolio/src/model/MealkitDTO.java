package model;

public class MealkitDTO {
	private String mealkitNo;
	private String mealkitName;
	private String mealkitImg;
	private String startDate;
	private String endDate;
	private String premium;
	
	public void setMealkitNo(String mealkitNo) {
		this.mealkitNo = mealkitNo;
	}
	public void setMealkitName(String mealkitName) {
		this.mealkitName = mealkitName;
	}
	public void setMealkitImg(String mealkitImg) {
		this.mealkitImg = mealkitImg;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	
	public String getMealkitNo() {
		return mealkitNo;
	}
	public String getMealkitName() {
		return mealkitName;
	}
	public String getMealkitImg() {
		return mealkitImg;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getPremium() {
		return premium;
	}

}
