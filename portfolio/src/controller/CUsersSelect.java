package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsersDTO;
import model.UsersSelect;

public class CUsersSelect implements CommandInterface {
	private static CUsersSelect cUSelect = new CUsersSelect();
	public static CUsersSelect getInstance() {
		return cUSelect;
	}
	
	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UsersSelect uSelect = UsersSelect.getInstance();
		HttpSession session = request.getSession();
		
		// 세션에서 id 값 가져와서 setId -> 해당 id를 가진 user 정보 select해오기
		UsersDTO user = new UsersDTO();
		user.setId((String)session.getAttribute("id"));
		UsersDTO userResult = uSelect.usersSelect(user);
		request.setAttribute("user", userResult);
		return "mealplanOrder.jsp";
	}
	
}
