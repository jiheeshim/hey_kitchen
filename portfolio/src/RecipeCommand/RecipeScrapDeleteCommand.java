package RecipeCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.RecipeScrapDeleteService;
import model.ActionForward;
import model.RecipeScrapDTO;

public class RecipeScrapDeleteCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id"); // 세션 아이디
		int recipeNo = Integer.parseInt(request.getParameter("recipeNo")); // 해당 레시피 번호
		
		// scrap 객체 값 설정		
		RecipeScrapDTO scrap = new RecipeScrapDTO();
		scrap.setRecipeNo(recipeNo);
		scrap.setId(id);
		
		// delete 실행
		RecipeScrapDeleteService recipeScrapDeleteService = new RecipeScrapDeleteService();
		int unscrapResult = recipeScrapDeleteService.unscrapRecipe(scrap);
		
		if(unscrapResult == 1) { // 스크랩 취소 성공 시,
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("recipeView.rec?recipeNo=" + recipeNo);
		} else if(unscrapResult == 2) { // 스크랩 취소할 게 없어서 실패 시,
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 스크랩 취소되었습니다.'); history.go(-1);</script>");
		} else { // DB 오류 시,
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('스크랩 중 오류가 발생하였습니다.'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
