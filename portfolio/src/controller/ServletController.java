package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// where : 어디로 이동하기 위해 컨트롤러로 왔는지 알 수 있는 parameter
		String where = request.getParameter("where");
		
		if(where.equals("mealplanOrder")) { // 가격 select + 배송일 select + 구독하기 페이지로 이동
			CMealplanPriceSelect cMppSelect = CMealplanPriceSelect.getInstance();
			CEndDateSelect cEdSelect = CEndDateSelect.getInstance();
			CUsersSelect cUSelect = CUsersSelect.getInstance();
			try {
				cMppSelect.commandData(request, response);
				cEdSelect.commandData(request, response);
				String page = cUSelect.commandData(request, response);
				request.getRequestDispatcher(page).forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("mealplanMenu")) { // 구독하기 페이지 정보(mealplan) 저장 + 밀키트 select + 메뉴 선택 페이지로 이동
			CMealkitSelect cMkSelect = CMealkitSelect.getInstance();
			try {
				String page = cMkSelect.commandData(request, response);
				request.getRequestDispatcher(page).forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("mealplanInsert")) { // mealplan & mealplanMenu & mealplanDelivery 테이블 insert + 완료 페이지로 이동
			CMealplanInsert cMpInsert = CMealplanInsert.getInstance();
			CMealplanDeliveryInsert cMpdInsert = CMealplanDeliveryInsert.getInstance();
			CMealplanMenuInsert cMpmInsert = CMealplanMenuInsert.getInstance();
			try {
				cMpInsert.commandData(request, response);
				cMpdInsert.commandData(request, response);
				String page = cMpmInsert.commandData(request, response);
				request.getRequestDispatcher(page).forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("where parameter 오류");
		}
	}
}
