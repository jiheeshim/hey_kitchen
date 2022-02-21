package RecipeService;

import java.sql.Connection;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import dao.RecipeDAO;
import model.IngrScrapDTO;

public class IngrScrapViewService {

	public ArrayList<IngrScrapDTO> getIngrScrapList(String id) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<IngrScrapDTO> ingrScrapList = recipeDAO.ingrScrapSelect(id);
		
		close(con);
		
		return ingrScrapList;
	}
}
