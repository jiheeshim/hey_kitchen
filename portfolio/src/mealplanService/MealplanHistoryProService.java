package mealplanService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.MealplanDAO;
import model.MealplanDTO;

public class MealplanHistoryProService {

	public ArrayList<MealplanDTO> getMealplanHistory(String id, String startDate, String endDate) {
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		
		ArrayList<MealplanDTO> mealplanList = mealplanDAO.mealplanHistorySelect(id, startDate, endDate);
		close(con);
		
		return mealplanList;
		
	}
}
