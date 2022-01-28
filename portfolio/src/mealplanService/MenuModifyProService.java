package mealplanService;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MealplanDAO;
import model.MealplanMenuDTO;

public class MenuModifyProService {

	public boolean modifyMenu(MealplanMenuDTO menu) {
		
		boolean modifySuccess = false;
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		
		int updateCount = mealplanDAO.menuUpdate(menu);
		if(updateCount > 0) {
			commit(con);
			modifySuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		return modifySuccess;
		
	}
}
