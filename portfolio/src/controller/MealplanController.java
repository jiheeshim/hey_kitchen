package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mealplanCommand.MealplanCommand;
import mealplanCommand.DeliveryModifyFormCommand;
import mealplanCommand.DeliveryModifyProCommand;
import mealplanCommand.MealplanCancelCommand;
import mealplanCommand.MealplanManageCommand;
import mealplanCommand.MenuModifyFormCommand;
import mealplanCommand.MenuModifyProCommand;
import mealplanCommand.MealplanHistoryFormCommand;
import mealplanCommand.MealplanHistoryProCommand;
import model.ActionForward;

@WebServlet("*.sub")
public class MealplanController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String where = requestURI.substring(contextPath.length());
		
		HttpSession session = request.getSession();
		ActionForward forward = null;
		MealplanCommand command = null;
		
		if(session.getAttribute("id") != null) { // 밀플랜 구독관리는 로그인 필수
			if(where.equals("/mealplanManage.sub")) {
			// mealplan, mealplanDelivery, mealkitNames 정보 불러오기
				command = new MealplanManageCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/deliveryModifyForm.sub")) {
			// mealplanDelivery 정보 불러온 후 배송지변경 페이지로 이동
				command = new DeliveryModifyFormCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/deliveryModifyPro.sub")) {
			// mealplanDelivery 정보 update한 후 구독관리 페이지로 이동
				command = new DeliveryModifyProCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/menuModifyForm.sub")) {
			// 현재 mealplanMenu 정보 가지고 메뉴 변경 페이지로 이동
				command = new MenuModifyFormCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/menuModifyPro.sub")) {
			// mealplanMenu 정보 update한 후 구독관리 페이지로 이동
				command = new MenuModifyProCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/mealplanHistoryForm.sub")) {
			// 오늘 날짜 정보 가지고 구독내역조회 페이지로 이동
				command = new MealplanHistoryFormCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/mealplanHistoryPro.sub")) {
			// date 기간에 포함된 mealplan 정보 가지고 구독내역조회 페이지로 이동
				command = new MealplanHistoryProCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/mealplanCancel.sub")) {
			// 현재 날짜로 구독 취소 업데이트한 후, 구독관리 Null 페이지로 이동
				command = new MealplanCancelCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} else { // 로그인 안 되어 있는 경우 로그인 페이지로 이동
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("login.jsp");  
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
