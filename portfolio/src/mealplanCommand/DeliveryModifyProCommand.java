package mealplanCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import model.MealplanDeliveryDTO;
import mealplanService.DeliveryModifyProService;

public class DeliveryModifyProCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		MealplanDeliveryDTO delivery = new MealplanDeliveryDTO();
		
		delivery.setDeliveryNo(request.getParameter("deliveryNo"));
		delivery.setPostcode(request.getParameter("postcode"));
		delivery.setAddr1(request.getParameter("addr1"));
		delivery.setExtraAddr(request.getParameter("extraAddr"));
		delivery.setAddr2(request.getParameter("addr2"));
		
		DeliveryModifyProService deliveryModifyProService = new DeliveryModifyProService();
		boolean modifySuccess = deliveryModifyProService.modifyDeliveryInfo(delivery);
		
		if(modifySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mealplanManage.sub");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('배송지 변경에 실패하였습니다.');location.href='mealplanManage.sub';</script>");
		}
		
		return forward;
	}

}
