package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mealplanCommand.MealplanCommand;
import mealplanCommand.MealplanManageCommand;
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
		
		if(where.equals("/mealplanManage.sub")) {
			if(session.getAttribute("id") != null) {
				command = new MealplanManageCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("login.jsp");
			}
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
