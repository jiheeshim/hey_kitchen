package mealplanService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MealplanDAO;
import model.MealplanDeliveryDTO;

public class DeliveryModifyProService {
	
	public boolean modifyDeliveryInfo(MealplanDeliveryDTO delivery) {
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		
		boolean modifySuccess = false;
		int updateCount = mealplanDAO.deliveryUpdate(delivery);
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
