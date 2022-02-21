package RecipeCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.IngrScrapDeleteService;
import model.ActionForward;

public class IngrScrapDeleteCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		IngrScrapDeleteService ingrScrapDeleteService = new IngrScrapDeleteService();
		
		// 삭제해야 할 재료리스트들이 있는 경우에만 delete 실행
		if(ingrScrapDeleteService.countIngrScrap(id) > 0) { 
			boolean deleteSuccess = ingrScrapDeleteService.deleteIngrScrap(id);
			
			if(deleteSuccess) {
				forward = new ActionForward();
				forward.setPath("ingrScrapSave.rec");
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('저장 중 오류가 발생하였습니다. 다시 시도해주세요.'); history.go(-1);</script>");
			}
		} else { // 삭제할 게 없는 경우 바로 save로 이동
			forward = new ActionForward();
			forward.setPath("ingrScrapSave.rec");
		}
		
		return forward;
	}

}
