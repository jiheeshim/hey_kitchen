package model;

public class RecipeImgDTO {
	private int imgNo;
	private int recipeNo;
	private String imgName;
	private String imgServerName;
	private String imgDesc;
	
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public void setImgServerName(String imgServerName) {
		this.imgServerName = imgServerName;
	}
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	
	public int getImgNo() {
		return imgNo;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public String getImgName() {
		return imgName;
	}
	public String getImgServerName() {
		return imgServerName;
	}
	public String getImgDesc() {
		return imgDesc;
	}
}
