package mealplanService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.MealplanDAO;
import model.MealplanDTO;
import model.MealplanDeliveryDTO;
import model.MealplanManageDTO;

public class MealplanManageService {
	
	public MealplanDTO getMealplanInfo(String id) {
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		MealplanDTO mealplan = mealplanDAO.mealplanSubSelect(id);
		close(con);
		return mealplan;
		
	}
	
	public MealplanDeliveryDTO getDeliveryInfo(String mealplanNo) {
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		MealplanDeliveryDTO delivery = mealplanDAO.deliverySubSelect(mealplanNo);
		close(con);
		return delivery;
		
	}
	
	public ArrayList<String> getMealkitNames(String deliveryNo) {
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		ArrayList<String> mealkitNames = mealplanDAO.mealkitSubSelect(deliveryNo);
		close(con);
		return mealkitNames;
		
	}

}
