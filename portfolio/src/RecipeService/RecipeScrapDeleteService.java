package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RecipeDAO;
import model.RecipeScrapDTO;

public class RecipeScrapDeleteService {

	public boolean unscrapRecipe(RecipeScrapDTO scrap) {
	// scrapDelete + minusScrapCount
		
		boolean unscrapResult = false;
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		int deleteCount = recipeDAO.deleteScrap(scrap);
		int updateCount = recipeDAO.minusScrapCount(scrap.getRecipeNo());
		
		if(deleteCount > 0 && updateCount > 0) {
			commit(con);
			unscrapResult = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return unscrapResult;
	}
}
