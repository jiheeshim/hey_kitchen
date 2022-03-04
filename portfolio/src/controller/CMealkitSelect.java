package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MealkitDTO;
import model.MealkitSelect;
import model.MealplanDTO;
import model.MealplanDeliveryDTO;
import model.MealplanDeliverySelect;
import model.MealplanSelect;

public class CMealkitSelect implements CommandInterface {
	
	private static CMealkitSelect cMkSelect = new CMealkitSelect();
	public static CMealkitSelect getInstance() {
		return cMkSelect;
	}

	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// mealkitSelect()를 실행하여 반환받은 List를 setAttribute() + 다음 페이지(mealplanMenu.jsp) 리턴
		MealplanDeliveryDTO mealplanDelivery = new MealplanDeliveryDTO();
		
		// 사용자가 선택한 deliverDate를 DB에 넣을 수 있는 날짜 포맷으로 변환하기
		String deliverDate = request.getParameter("deliverDate");
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일", Locale.KOREAN);
		DateTimeFormatter strFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		deliverDate = LocalDate.parse(deliverDate, dateFmt).format(strFmt);

		// mealplanOrder페이지의 input 정보들(mealplan 테이블)을 다음페이지에서도 쓸 수 있게 setAttribute()
		MealplanDTO mealplan = new MealplanDTO();
		
		// 구독번호 생성 & 중복체크 : createMealplanNo()를 통해 구독번호 생성한 후,
		// mealplan 객체에 해당 구독번호 값을 설정하여, mealplan 객체와 같은 구독번호로 select한 결과가 null이 아니면, 구독번호 재생
		String mealplanNo = createMealplanNo(); // mealplanNo 생성
		mealplan.setMealplanNo(mealplanNo); 
		MealplanSelect mpSelect = MealplanSelect.getInstance();
		while(mpSelect.mealplanSelect(mealplan) != null) { // 중복되는 경우,
			mealplanNo = createMealplanNo(); // 재생성
			mealplan.setMealplanNo(mealplanNo);
		}
		
		mealplan.setServing(Integer.parseInt(request.getParameter("serving")));
		mealplan.setServingCnt(Integer.parseInt(request.getParameter("servingCnt")));
		request.setAttribute("mealplan", mealplan);
		
		// 배달번호 생성 & 중복체크
		String deliveryNo = createDeliveryNo();
		mealplanDelivery.setDeliveryNo(deliveryNo);
		MealplanDeliverySelect mpdSelect = MealplanDeliverySelect.getInstance();
		while(mpdSelect.mealplanDeliverySelect(mealplanDelivery) != null) {
			deliveryNo = createDeliveryNo();
			mealplanDelivery.setDeliveryNo(deliveryNo);
		}
		
		mealplanDelivery.setPostcode(request.getParameter("postcode"));
		mealplanDelivery.setAddr1(request.getParameter("addr1"));
		mealplanDelivery.setExtraAddr(request.getParameter("extraAddr"));
		mealplanDelivery.setAddr2(request.getParameter("addr2"));
		mealplanDelivery.setDeliverDate(deliverDate);
		request.setAttribute("mealplanDelivery", mealplanDelivery);
		
		// 사용자가 선택한 deliverDate에 해당하는 주간의 mealkit 메뉴 select해서 setAttribute()
		MealkitSelect mkSelect = MealkitSelect.getInstance();
		List<MealkitDTO> mealkitList = mkSelect.mealkitSelect(mealplanDelivery);
		request.setAttribute("mealkitList", mealkitList);
		return "mealplanMenu.jsp";
	}
	
	// mealplanNo(구독번호) : S(Subscription) + yyMMdd(현재날짜=구독신청날짜) + 랜덤숫자(100~999)
	public String createMealplanNo() {
		DateTimeFormatter noFmt = DateTimeFormatter.ofPattern("yyMMdd"); // mealplanNo용 현재날짜포맷
		String random = Integer.toString((int)(Math.random() * 900) + 100); // 3자리 랜덤숫자 생성
		String mealplanNo = "S" + LocalDate.now().format(noFmt) + random;
		return mealplanNo;
	}
	
	// deliveryNo(배달번호) : D(Delivery) + yyMMdd(현재날짜=새배달등록날짜) + 랜덤숫자(100~999)
	public String createDeliveryNo() {
		DateTimeFormatter noFmt = DateTimeFormatter.ofPattern("yyMMdd");
		String random = Integer.toString((int)(Math.random() * 900) + 100);
		String deliveryNo = "D" + LocalDate.now().format(noFmt) + random;
		return deliveryNo;
	}
	
}
