package model;

public class IngrScrapDTO {
	
	private int ingrNo;
	private String ingr;
	private String checked;
	private String id;
	
	public void setIngrNo(int ingrNo) {
		this.ingrNo = ingrNo;
	}
	public void setIngr(String ingr) {
		this.ingr = ingr;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getIngrNo() {
		return ingrNo;
	}
	public String getIngr() {
		return ingr;
	}
	public String getChecked() {
		return checked;
	}
	public String getId() {
		return id;
	}
	
}
