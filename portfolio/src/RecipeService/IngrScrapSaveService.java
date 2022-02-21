package RecipeService;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.RecipeDAO;
import model.IngrScrapDTO;

public class IngrScrapSaveService {

	public boolean saveIngrScrap(IngrScrapDTO ingrScrap) {
		
		boolean saveSuccess = false;
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		int insertCount = recipeDAO.ingrScrapInsert(ingrScrap);
		
		if(insertCount > 0) {
			commit(con);
			saveSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return saveSuccess;
	}
}
