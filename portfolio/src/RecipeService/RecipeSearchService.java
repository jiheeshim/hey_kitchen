package RecipeService;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RecipeDAO;

import static db.JdbcUtil.*;
import model.RecipeDTO;

public class RecipeSearchService {
	
	public int getSearchCount(String searchTxt) throws Exception {
		
		int listCount = 0;
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		listCount = recipeDAO.searchCountSelect(searchTxt);
		
		close(con);
		
		return listCount;
	}
	
	public ArrayList<RecipeDTO> searchRecipeList(String searchTxt, int page, int limit) throws Exception {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<RecipeDTO> recipeList = recipeDAO.searchRecipeList(searchTxt, page, limit);
		
		close(con);
		
		return recipeList;
	}

}
