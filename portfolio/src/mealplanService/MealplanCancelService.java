package mealplanService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MealplanDAO;
import model.MealplanDTO;

public class MealplanCancelService {

	public String getMealplanNo(String id) {
		
		String mealplanNo = null;
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		
		MealplanDTO mealplan = mealplanDAO.mealplanSubSelect(id); // 현재 구독 중인 밀플랜 정보 불러오기
		if(mealplan != null) {
			mealplanNo = mealplan.getMealplanNo();
		}
		
		return mealplanNo;
		
	}
	
	public boolean cancelMealplan(String cancelDate, String mealplanNo) {
		
		boolean cancelSuccess = false;
		
		Connection con = getConnection();
		MealplanDAO mealplanDAO = MealplanDAO.getInstance();
		mealplanDAO.setConnection(con);
		
		int updateCount = mealplanDAO.mealplanCancelUpdate(cancelDate, mealplanNo);
		if(updateCount > 0) {
			commit(con);
			cancelSuccess = true;
		} else {
			rollback(con);
		}
		
		return cancelSuccess;
		
	}
}
