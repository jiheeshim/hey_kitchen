package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MealkitDTO;
import model.MealplanDTO;
import model.MealplanDeliveryDTO;
import model.MealplanPayService;
import model.MealplanPriceDTO;
import model.UsersDTO;

public class CMealplanPay implements CommandInterface {

	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// mealplan 객체 저장
		MealplanDTO mealplan = new MealplanDTO();
		mealplan.setMealplanNo(request.getParameter("mealplanNo"));
		mealplan.setServing(Integer.parseInt(request.getParameter("serving")));
		mealplan.setServingCnt(Integer.parseInt(request.getParameter("servingCnt")));
		request.setAttribute("mealplan", mealplan);
		
		// mealplanDelivery 객체 저장
		MealplanDeliveryDTO mealplanDelivery = new MealplanDeliveryDTO();
		mealplanDelivery.setDeliveryNo(request.getParameter("deliveryNo"));
		mealplanDelivery.setPostcode(request.getParameter("postcode"));
		mealplanDelivery.setAddr1(request.getParameter("addr1"));
		mealplanDelivery.setExtraAddr(request.getParameter("extraAddr"));
		mealplanDelivery.setAddr2(request.getParameter("addr2"));
		mealplanDelivery.setDeliverDate(request.getParameter("deliverDate"));
		request.setAttribute("mealplanDelivery", mealplanDelivery);
		
		// mealkitNo 저장
		String[] mealkitNoArr = request.getParameterValues("mealkitNo");
		request.setAttribute("mealkitNoArr", mealkitNoArr);
		// mealkitNo에 따른 mealkitName 저장
		MealplanPayService mealplanPayService = new MealplanPayService();
		List<MealkitDTO> mealkitNameList = mealplanPayService.mealkitNameSelect(mealkitNoArr);
		request.setAttribute("mealkitNameList", mealkitNameList);
		
		// servingCnt에 따른 price 저장
		MealplanPriceDTO mealplanPrice = new MealplanPriceDTO();
		mealplanPrice.setServingCnt(Integer.parseInt(request.getParameter("servingCnt")));
		int price = mealplanPayService.priceSelect(mealplanPrice);
		request.setAttribute("price", price);
		
		// user 정보 저장
		HttpSession session = request.getSession();
		UsersDTO users = new UsersDTO();
		users.setId((String)session.getAttribute("id"));
		UsersDTO user = mealplanPayService.usersSelect(users);
		request.setAttribute("user", user);
		
		return "mealplanPay.jsp";
	}

}
