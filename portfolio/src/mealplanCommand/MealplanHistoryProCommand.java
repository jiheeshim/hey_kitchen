package mealplanCommand;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mealplanService.MealplanHistoryProService;
import model.ActionForward;
import model.MealplanDTO;

public class MealplanHistoryProCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		
		LocalDate today = LocalDate.now();
		LocalDate month1 = today.minusMonths(1);
		LocalDate month3 = today.minusMonths(3);
		LocalDate month6 = today.minusMonths(6);
		request.setAttribute("today", today);
		request.setAttribute("month1", month1);
		request.setAttribute("month3", month3);
		request.setAttribute("month6", month6);
		
		MealplanHistoryProService mealplanHistoryProService = new MealplanHistoryProService();
		ArrayList<MealplanDTO> mealplanList = mealplanHistoryProService.getMealplanHistory(id, startDate, endDate);
		request.setAttribute("mealplanList", mealplanList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/mealplanManageSubHistory2.jsp");
		
		return forward;
	}

}
