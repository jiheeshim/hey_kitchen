package RecipeService;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RecipeDAO;

import static db.JdbcUtil.*;
import model.RecipeDTO;

public class RecipeScrapViewService {
	
	public ArrayList<RecipeDTO> getScrapRecipeList(String id) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<RecipeDTO> recipeList = recipeDAO.scrapRecipeSelect(id);
		
		close(con);
		
		return recipeList;
	}

}
