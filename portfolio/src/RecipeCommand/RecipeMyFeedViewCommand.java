package RecipeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.RecipeMyFeedViewService;
import model.ActionForward;
import model.RecipeDTO;

public class RecipeMyFeedViewCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		RecipeMyFeedViewService recipeMyFeedViewService = new RecipeMyFeedViewService();
		
		// id와 해당 id의 레시피 목록 setAttribute()
		String id = (String)session.getAttribute("id");
		ArrayList<RecipeDTO> recipeList = recipeMyFeedViewService.getMyFeedList(id);
		request.setAttribute("recipeList", recipeList); 
		request.setAttribute("id", id); 
		
		ActionForward forward = new ActionForward();
		forward.setPath("/recipeMyFeed.jsp");
		
		return forward;
	}

}
