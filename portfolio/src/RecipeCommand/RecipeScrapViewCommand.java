package RecipeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.RecipeScrapViewService;
import model.ActionForward;
import model.RecipeDTO;

public class RecipeScrapViewCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 현재 id 가져오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		// id로 scrap한 recipeList 받아와서 저장
		RecipeScrapViewService recipeScrapViewService = new RecipeScrapViewService();
		ArrayList<RecipeDTO> recipeList = recipeScrapViewService.getScrapRecipeList(id);
		request.setAttribute("recipeList", recipeList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/recipeScrap.jsp");
		
		return forward;
	}

}
