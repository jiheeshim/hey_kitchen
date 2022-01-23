package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MealplanDeliveryDTO;
import model.MealplanDeliveryInsert;
import model.MealplanDeliverySelect;

public class CMealplanDeliveryInsert implements CommandInterface {
	private static CMealplanDeliveryInsert cMpdInsert = new CMealplanDeliveryInsert();
	public static CMealplanDeliveryInsert getInstance() {
		return cMpdInsert;
	}
	
	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MealplanDeliveryInsert mpdInsert = MealplanDeliveryInsert.getInstance();
		MealplanDeliveryDTO mealplanDelivery = new MealplanDeliveryDTO();
		
		mealplanDelivery.setDeliveryNo(request.getParameter("deliveryNo"));
		mealplanDelivery.setMealplanNo(request.getParameter("mealplanNo"));
		mealplanDelivery.setPostcode(request.getParameter("postcode"));
		mealplanDelivery.setAddr1(request.getParameter("addr1"));
		mealplanDelivery.setExtraAddr(request.getParameter("extraAddr"));
		mealplanDelivery.setAddr2(request.getParameter("addr2"));
		mealplanDelivery.setDeliverDate(request.getParameter("deliverDate"));
		
		int result = mpdInsert.mealplanDeliveryInsert(mealplanDelivery);
		if(result != 1)
			System.out.println("mealplanDelivery insert 오류");
		return "mealplanFinish.jsp";
	}
	
}
