package model;

public class RecipeScrapDTO {

	private String id;
	private int recipeNo;
	
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getRecipeNo() {
		return recipeNo;
	}
	public String getId() {
		return id;
	}
	
}
