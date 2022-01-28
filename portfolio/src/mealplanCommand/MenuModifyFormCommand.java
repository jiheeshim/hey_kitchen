package mealplanCommand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mealplanService.MenuModifyFormService;
import model.ActionForward;
import model.MealkitDTO;
import model.MealkitSelect;
import model.MealplanDeliveryDTO;
import model.MealplanMenuDTO;

public class MenuModifyFormCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// mealkitSelect() 로 mealkitList 불러와서 setAttribute()
		MealkitSelect mkSelect = MealkitSelect.getInstance();
		MealplanDeliveryDTO mealplanDelivery = new MealplanDeliveryDTO();
		mealplanDelivery.setDeliverDate(request.getParameter("deliverDate"));
		List<MealkitDTO> mealkitList = mkSelect.mealkitSelect(mealplanDelivery);
		request.setAttribute("mealkitList", mealkitList);
		
		// deliveryNo로 mealplanMenu 데이터 리스트 형태로 불러오기
		// setAttribute()해서 반복문으로 필요한 만큼 메뉴 selectbox만들 수 있도록
		String deliveryNo = request.getParameter("deliveryNo");
		MenuModifyFormService menuModifyFormService = new MenuModifyFormService();
		ArrayList<MealplanMenuDTO> menuList = menuModifyFormService.getMenuList(deliveryNo);
		request.setAttribute("menuList", menuList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/mealplanManageMenu.jsp");
		
		return forward;
	}

}
