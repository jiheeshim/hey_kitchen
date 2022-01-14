package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MealplanDTO;
import model.MealplanInsert;
import model.MealplanSelect;

public class CMealplanInsert implements CommandInterface {
	
	private static CMealplanInsert cMpInsert = new CMealplanInsert();
	public static CMealplanInsert getInstance() {
		return cMpInsert;
	}
	
	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MealplanInsert mpInsert = MealplanInsert.getInstance();
		MealplanDTO mealplan = new MealplanDTO();
		
		// mealplan 객체의 속성 값 설정
		mealplan.setMealplanNo(request.getParameter("mealplanNo"));
		mealplan.setId((String)session.getAttribute("id"));
		mealplan.setServing(Integer.parseInt(request.getParameter("serving")));
		mealplan.setServingCnt(Integer.parseInt(request.getParameter("servingCnt")));
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // subDate용 현재날짜포맷
		mealplan.setSubDate(LocalDate.now().format(dateFmt));
		
		// 구독 완료 페이지에서 보여줄 구독번호 setAttribute()
		request.setAttribute("mealplanNo", mealplan.getMealplanNo());
		
		int result = mpInsert.mealplanInsert(mealplan);
		
		if(result != 1) {
			System.out.println("insert 오류");
		}
		return "mealplanFinish.jsp"; 
	}
	
}
