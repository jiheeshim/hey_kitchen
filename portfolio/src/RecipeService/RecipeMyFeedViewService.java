package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RecipeDAO;
import model.RecipeDTO;

public class RecipeMyFeedViewService {
	
	public ArrayList<RecipeDTO> getMyFeedList(String id) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<RecipeDTO> recipeList = recipeDAO.myFeedSelect(id);
		
		close(con);
		
		return recipeList;
	}

}
