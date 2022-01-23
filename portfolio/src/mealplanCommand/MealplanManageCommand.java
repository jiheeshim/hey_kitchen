package mealplanCommand;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mealplanService.MealplanManageService;
import model.ActionForward;
import model.MealplanDTO;
import model.MealplanDeliveryDTO;
import model.MealplanManageDTO;

public class MealplanManageCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		ActionForward forward = null;
		MealplanManageService mealplanManageService = new MealplanManageService();
		
		MealplanDTO mealplan = mealplanManageService.getMealplanInfo((String)session.getAttribute("id"));
		if(mealplan != null) {
			String mealplanNo = mealplan.getMealplanNo();
			MealplanDeliveryDTO delivery = mealplanManageService.getDeliveryInfo(mealplanNo);
			if(delivery != null) {
				String deliveryNo = delivery.getDeliveryNo();
				ArrayList<String> mealkitNames = mealplanManageService.getMealkitNames(deliveryNo);
				
				request.setAttribute("mealplan", mealplan);
				request.setAttribute("delivery", delivery);
				request.setAttribute("mealkitNames", mealkitNames);
				
				forward = new ActionForward();
				forward.setPath("/mealplanManage.jsp");
			} else { // 구독 정보는 있는데 현재 날짜 기준으로 다음 배송 정보가 없는 경우
				PrintWriter out = response.getWriter();
				out.println("<script>alert('다음 배송 정보를 불러오는데 실패하였습니다. -구독 자동 갱신 기능 준비중-'); location.href('mealplanManageNull.jsp');</script>");
			}
		} else { // 구독 정보가 없는 경우
			forward = new ActionForward();
			forward.setPath("/mealplanManageNull.jsp");
		}
		
		return forward;
	}

}
