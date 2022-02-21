package model;

public class MyReviewDTO {
	
	private int recipeNo;
	private String recipeName;
	private String content;
	private String id;
	private String regDate;
	private String editDate;
	
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	public int getRecipeNo() {
		return recipeNo;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public String getContent() {
		return content;
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
