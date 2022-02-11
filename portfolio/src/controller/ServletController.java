package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MealplanSelectID;

@WebServlet("*.kitchen")
public class ServletController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		// where : 어디로 이동하기 위해 컨트롤러로 왔는지 알 수 있는 parameter
		String where = request.getParameter("where");
		
		if(where.equals("mealplanOrder")) { // 가격 select + 배송일 select + 구독하기 페이지로 이동
			CMealplanPriceSelect cMppSelect = CMealplanPriceSelect.getInstance();
			CEndDateSelect cEdSelect = CEndDateSelect.getInstance();
			CUsersSelect cUSelect = CUsersSelect.getInstance();
			CMealplanSelectID cMpSelectID = CMealplanSelectID.getInstance();
			if(session.getAttribute("id") != null) { // 로그인 되어 있으면 실행
				try {
					if(cMpSelectID.commandData(request, response).equals("null")) { // 세션 아이디로 현재 진행중인 구독 정보가 없으면 실행
						cMppSelect.commandData(request, response);
						cEdSelect.commandData(request, response);
						String page = cUSelect.commandData(request, response);
						request.getRequestDispatcher(page).forward(request, response);
					} else { // 현재 진행 중인 구독 정보가 있으면 구독 관리 페이지로 이동
						response.sendRedirect("mealplanManage.sub");
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else { // 로그인 안 되어 있으면 로그인 페이지로
				response.sendRedirect("login.jsp");
			}
		} else if(where.equals("mealplanMenu")) { // 구독하기 페이지 정보(mealplan) 저장 + 밀키트 select + 메뉴 선택 페이지로 이동
			CMealkitSelect cMkSelect = CMealkitSelect.getInstance();
			if(session.getAttribute("id") != null) {
				try {
					String page = cMkSelect.commandData(request, response);
					request.getRequestDispatcher(page).forward(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if(where.equals("mealplanInsert")) { // mealplan & mealplanMenu & mealplanDelivery 테이블 insert + 완료 페이지로 이동
			CMealplanInsert cMpInsert = CMealplanInsert.getInstance();
			CMealplanDeliveryInsert cMpdInsert = CMealplanDeliveryInsert.getInstance();
			CMealplanMenuInsert cMpmInsert = CMealplanMenuInsert.getInstance();
			if(session.getAttribute("id") != null) {
				try {
					cMpInsert.commandData(request, response);
					cMpdInsert.commandData(request, response);
					String page = cMpmInsert.commandData(request, response);
					request.getRequestDispatcher(page).forward(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				response.sendRedirect("login.jsp");
			}
		} else {
			System.out.println("where parameter 오류");
			System.out.println(where);
		}
	}
}
