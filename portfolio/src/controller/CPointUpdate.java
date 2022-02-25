package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PointUpdate;
import model.UsersDTO;

public class CPointUpdate implements CommandInterface {

	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		UsersDTO user = new UsersDTO();
		user.setId(id); // 현재 아이디
		user.setPoint(Integer.parseInt(request.getParameter("pointUsage"))); // 사용 적립금액
		PointUpdate pointUpdate = new PointUpdate();
		int result = pointUpdate.pointUpdate(user);
		if(result != 1) {
			System.out.println("pointupdate 오류");
		}
		
		return "mealplanFinish.jsp";
	}

}
