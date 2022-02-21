package RecipeService;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RecipeDAO;

import static db.JdbcUtil.*;
import model.MyReviewDTO;

public class MyReviewViewService {
	
	public ArrayList<MyReviewDTO> getMyReviewList(String id) {
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<MyReviewDTO> myReviewList = recipeDAO.myReviewSelect(id);
		
		close(con);
		
		return myReviewList;
	}

}
