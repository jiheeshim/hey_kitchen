package mealplanCommand;

import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mealplanService.MealplanCancelService;
import model.ActionForward;

public class MealplanCancelCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		boolean cancelSuccess = false;
		HttpSession session = request.getSession();
		MealplanCancelService mealplanCancelService = new MealplanCancelService();
		
		String cancelDate = LocalDate.now().toString();
		String mealplanNo = mealplanCancelService.getMealplanNo((String)session.getAttribute("id")); // 세션 아이디로 현재 구독 중인 구독번호 구하기
		
		if(mealplanNo != null) {
			
			// 구독 중인 밀플랜 구독번호가 있으면, cancelDate update
			cancelSuccess = mealplanCancelService.cancelMealplan(cancelDate, mealplanNo);
			
			if(cancelSuccess) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('구독이 취소되었습니다.'); location.href='mealplanManage.sub'; </script>");
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('구독 취소 중 오류가 발생하였습니다.'); history.go(-1);</script>");
			}
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('현재 구독 중인 밀플랜이 없습니다.'); location.href='mealplanManageNull.jsp'; </script>");
		}
		
		return forward;
	}

}
