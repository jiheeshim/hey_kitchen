package mealplanCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mealplanService.MealplanManageService;
import model.ActionForward;
import model.MealplanDTO;
import model.MealplanDeliveryDTO;

public class DeliveryModifyFormCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mealplanNo = request.getParameter("mealplanNo");
		MealplanManageService mealplanManageService = new MealplanManageService();
		MealplanDeliveryDTO delivery = mealplanManageService.getDeliveryInfo(mealplanNo);
		request.setAttribute("delivery", delivery);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/mealplanManageDelivery.jsp");
		
		return forward;
	}

}
