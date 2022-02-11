package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RecipeDAO;
import model.RecipeDTO;
import model.RecipeImgDTO;

public class RecipeRegisterProService {

	public int getMaxNo() {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		int maxNo = recipeDAO.maxNoSelect();
		
		close(con);
		
		return maxNo;
		
	}
	
	public boolean registerRecipe(RecipeDTO recipe) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		boolean isSuccess = false;
		
		int insertCount = recipeDAO.recipeInsert(recipe);
		if(insertCount > 0) {
			isSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return isSuccess;
	}
	
	public boolean registerRecipeImg(RecipeImgDTO recipeImg) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		boolean isSuccess = false;
		
		int insertCount = recipeDAO.recipeImgInsert(recipeImg);
		if(insertCount > 0) {
			isSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return isSuccess;
	}
}
