package controller;

import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MealplanMenuDTO;
import model.MealplanMenuInsert;

public class CMealplanMenuInsert implements CommandInterface {
	
	private static CMealplanMenuInsert cMpmInsert = new CMealplanMenuInsert();
	public static CMealplanMenuInsert getInstance() {
		return cMpmInsert;
	}
	
	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MealplanMenuInsert mpmInsert = MealplanMenuInsert.getInstance();
		MealplanMenuDTO mealplanMenu = new MealplanMenuDTO();
		
		// mealplanMenu 속성 값 설정 + insert
		String deliveryNo = request.getParameter("deliveryNo");
		String[] mealkitNoArr = request.getParameterValues("mealkitNo");
		
		for(int i = 0; i < mealkitNoArr.length; i++) {
			String menuNo = deliveryNo.substring(1) + (i + 1); // menuNo(구독메뉴번호) : 배송번호의 'D' 뒤 9자리 + 1~5 (메뉴 종류는 5개까지 주문 가능)
			String mealkitNo = mealkitNoArr[i];
			
			mealplanMenu.setMenuNo(menuNo);
			mealplanMenu.setDeliveryNo(deliveryNo);
			mealplanMenu.setMealkitNo(mealkitNo);
			
			int result = mpmInsert.mealplanMenuInsert(mealplanMenu);
			if(result != 1)
				System.out.println("mealplanMenu insert 오류");
		}
		
		return "mealplanFinish.jsp"; // 완료 페이지
	}
	
}
