package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RecipeDAO;
import model.IngrScrapDTO;

public class IngrScrapProService {

	public boolean scrapIngr(IngrScrapDTO ingrScrap) {
		
		boolean scrapSuccess = false;
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		int insertCount = recipeDAO.ingrScrapInsert(ingrScrap);
		
		if(insertCount > 0) {
			commit(con);
			scrapSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return scrapSuccess;
	}
}
