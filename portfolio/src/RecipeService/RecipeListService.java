package RecipeService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.RecipeDAO;
import model.RecipeDTO;

public class RecipeListService {
	
	// 선택한 카테고리를 가진 레시피 개수 가져오기
	public int getListCount(String category) throws Exception {
		
		int listCount = 0;
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		listCount = recipeDAO.listCountSelect(category);
		
		close(con);
		
		return listCount;
	}
	
	// 선택한 카테고리에 맞는 레시피들 모두 가져오기
	public ArrayList<RecipeDTO> getRecipeList(String category, int page, int limit) throws Exception {
		
		ArrayList<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		recipeList = recipeDAO.recipeListSelect(category, page, limit);
		
		close(con);
		
		return recipeList;
	}

}
