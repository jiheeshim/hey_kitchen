package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EndDateSelect;
import model.MealkitDTO;

public class CEndDateSelect implements CommandInterface {

	private static CEndDateSelect cEdSelect = new CEndDateSelect();
	public static CEndDateSelect getInstance() {
		return cEdSelect;
	}
	
	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// endDateSelect()를 통해 가장 늦은 endDate를 불러오고, (현재날짜+3일 ~ endDate)까지 ArrayList에 저장한 후 setAttribute() + "mealplanOrder.jsp" 반환
	// cf. 3일 : 배송 준비 기간 & endDate : 밀키트 별 배송 가능 마지막 날짜
		
	// LocalDate를 사용하면, Date와 Calendar를 따로 사용할 필요 없음!!! 단, jstl태그에서 LocalDate타입은 인식이 안되기 때문에 String으로 바꿔줘야 함(그래도 jstl에서 fmt 쓰는 것보다 자바코드로 타입 변환하는 게 더 쉬워서)
		
		// endDateSelect()를 통해 가장 늦은 endDate가 담긴 mealkit객체 가져오기 
		EndDateSelect edSelect = EndDateSelect.getInstance();
		MealkitDTO mealkit = edSelect.endDateSelect(); 
		
		ArrayList<String> dateList = new ArrayList<String>(); // selectbox에 넘길 날짜들 ArrayList 
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // String -> LocalDate 변환 시 사용할 formatter
		DateTimeFormatter strFmt = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일", Locale.KOREAN); // LocalDate -> String 변환 시 사용할 formatter
		
		// EndDate String -> 날짜형태로 바꾸기
		LocalDate endDate = LocalDate.parse(mealkit.getEndDate(), dateFmt);
		// 현재 날짜 + 3일째 구하기
		LocalDate date = LocalDate.now().plusDays(3);
		
		while(date.compareTo(endDate) <= 0) { // date ~ endDate를 dateList에 추가
			if(date.getDayOfWeek().getValue() == 7) {
				date = date.plusDays(1);
				continue;
			}
			dateList.add(date.format(strFmt)); 
			date = date.plusDays(1);
		}
		request.setAttribute("dateList", dateList);
		
		return "mealplanOrder.jsp";
	}
	
}
