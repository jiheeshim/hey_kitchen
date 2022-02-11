package model;

public class RecipeReviewDTO {

	private int reviewNo;
	private int recipeNo;
	private String content;
	private String imgName;
	private String imgServerName;
	private String id;
	private String regDate;
	private String editDate;
	
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public void setImgServerName(String imgServerName) {
		this.imgServerName = imgServerName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	
	public int getReviewNo() {
		return reviewNo;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public String getContent() {
		return content;
	}
	public String getImgName() {
		return imgName;
	}
	public String getImgServerName() {
		return imgServerName;
	}
	public String getId() {
		return id;
	}
	public String getRegDate() {
		return regDate;
	}
	public String getEditDate() {
		return editDate;
	}
}
