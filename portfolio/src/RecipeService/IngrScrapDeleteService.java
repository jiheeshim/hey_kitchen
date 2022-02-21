package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RecipeDAO;
import model.IngrScrapDTO;

public class IngrScrapDeleteService {
	
	public int countIngrScrap(String id) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<IngrScrapDTO> ingrScrapList = recipeDAO.ingrScrapSelect(id);
		
		close(con);
		
		int ingrScrapListCount = ingrScrapList.size();
		
		return ingrScrapListCount;
	}
	
	public boolean deleteIngrScrap(String id) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		int deleteCount = recipeDAO.deleteIngrScrap(id);
		
		boolean deleteSuccess = false;
		if(deleteCount > 0) {
			commit(con);
			deleteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return deleteSuccess;
	}

}
