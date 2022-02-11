package RecipeService;

import java.sql.Connection;

import static db.JdbcUtil.*;
import dao.RecipeDAO;

public class ReviewDeleteService {

	public boolean deleteReview(int reviewNo) {
		
		boolean deleteSuccess = false;
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		int deleteCount = recipeDAO.deleteReview(reviewNo);
		
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
