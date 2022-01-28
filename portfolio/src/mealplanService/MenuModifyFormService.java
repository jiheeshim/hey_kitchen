package mealplanService;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MealplanDAO;
import model.MealplanMenuDTO;

public class MenuModifyFormService {

	public ArrayList<MealplanMenuDTO> getMenuList(String deliveryNo) {
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		
		ArrayList<MealplanMenuDTO> menuList = mealplanDAO.mealplanMenuSelect(deliveryNo);
		
		return menuList;
	}
}
