package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MealplanDTO;
import model.MealplanSelectID;

public class CMealplanSelectID implements CommandInterface {

	private static CMealplanSelectID cMpSelectID = new CMealplanSelectID();
	public static CMealplanSelectID getInstance() {
		return cMpSelectID;
	}
	
	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MealplanSelectID mpSelectID = MealplanSelectID.getInstance();
		HttpSession session = request.getSession();
		MealplanDTO mealplan = new MealplanDTO();
		mealplan.setId((String)session.getAttribute("id"));
		MealplanDTO mealplanResult = mpSelectID.mealplanSelectID(mealplan);
		if(mealplanResult != null) {
			request.setAttribute("mealplan", mealplanResult);
			return "mealplanManage.jsp";
		} else {
			return "null";
		}
		
	}
	
}
