package model;

public class RecipeDTO {
	private int recipeNo;
	private String recipeName;
	private String thumbnail;
	private String thumbnailServer;
	private String category;
	private int readCount;
	private int scrapCount;
	private String recipeDesc;
	private String ingredients;
	private String id;
	private String regDate;
	private String editDate;
	
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public void setThumbnailServer(String thumbnailServer) {
		this.thumbnailServer = thumbnailServer;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public void setScrapCount(int scrapCount) {
		this.scrapCount = scrapCount;
	}
	public void setRecipeDesc(String recipeDesc) {
		this.recipeDesc = recipeDesc;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
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
	public String getThumbnail() {
		return thumbnail;
	}
	public String getThumbnailServer() {
		return thumbnailServer;
	}
	public String getCategory() {
		return category;
	}
	public int getReadCount() {
		return readCount;
	}
	public int getScrapCount() {
		return scrapCount;
	}
	public String getRecipeDesc() {
		return recipeDesc;
	}
	public String getIngredients() {
		return ingredients;
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
