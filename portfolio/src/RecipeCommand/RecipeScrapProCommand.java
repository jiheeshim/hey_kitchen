package RecipeCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.RecipeScrapProService;
import model.ActionForward;
import model.RecipeScrapDTO;

public class RecipeScrapProCommand implements RecipeCommand {

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
		
		// insert 실행
		RecipeScrapProService recipeScrapProService = new RecipeScrapProService();
		int scrapResult = recipeScrapProService.scrapRecipe(scrap);
		
		// 결과 값에 따른 실행
		if(scrapResult == 1) { // 스크랩 성공
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("recipeView.rec?recipeNo=" + recipeNo);
		} else if(scrapResult == 2) { // 이미 스크랩되어 있는 경우(스크랩한 후, 뒤로가기 후 다시 아이콘 누르면 가능한 상황)
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 스크랩되었습니다. 레시피 스크랩 갤러리를 확인해주세요.'); history.go(-1);</script>");
		} else { // db 처리 오류
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('스크랩 중 오류가 발생하였습니다.'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
