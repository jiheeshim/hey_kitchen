package mealplanCommand;



import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;

public class MealplanHistoryFormCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 조회 기간 관련 날짜 설정
		LocalDate today = LocalDate.now();
		LocalDate month1 = today.minusMonths(1);
		LocalDate month3 = today.minusMonths(3);
		LocalDate month6 = today.minusMonths(6);
		request.setAttribute("today", today);
		request.setAttribute("month1", month1);
		request.setAttribute("month3", month3);
		request.setAttribute("month6", month6);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/mealplanManageSubHistory.jsp");
		
		return forward;
	}

}
