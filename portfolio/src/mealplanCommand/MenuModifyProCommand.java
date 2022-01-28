package mealplanCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mealplanService.MenuModifyProService;
import model.ActionForward;
import model.MealplanMenuDTO;

public class MenuModifyProCommand implements MealplanCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		MenuModifyProService menuModifyProService = new MenuModifyProService();
		MealplanMenuDTO menu = null;
		String[] menuNoArr = request.getParameterValues("menuNo");
		String[] mealkitNoArr = request.getParameterValues("mealkitNo");
		int modifyResult = 0;
		
		if(menuNoArr.length == mealkitNoArr.length) {
			for(int i = 0 ; i < menuNoArr.length ; i++) {
				menu = new MealplanMenuDTO();
				menu.setMenuNo(menuNoArr[i]);
				menu.setMealkitNo(mealkitNoArr[i]);
				boolean modifySuccess = menuModifyProService.modifyMenu(menu);
				if(modifySuccess) {
					modifyResult++;
				}
			}
		}
		
		if(modifyResult == menuNoArr.length) { // 받아온 값의 개수만큼 update 성공하면,
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mealplanManage.sub");
		} else { // 실패하면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert(''); location.href='mealplanManage.sub';</script>");
		}
		
		return forward;
	}

}
