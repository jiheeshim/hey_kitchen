package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RecipeDAO;
import model.RecipeReviewDTO;

public class ReviewReplyProService {

	public boolean replyReview(RecipeReviewDTO review) {
		
		boolean replySuccess = false;
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		int insertCount = recipeDAO.reviewInsert(review);
		
		if(insertCount > 0) {
			commit(con);
			replySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return replySuccess;
		
	}
}
