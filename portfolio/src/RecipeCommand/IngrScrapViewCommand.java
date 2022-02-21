package RecipeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.IngrScrapViewService;
import model.ActionForward;
import model.IngrScrapDTO;

public class IngrScrapViewCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		request.setAttribute("id", id);
		
		IngrScrapViewService ingrScrapViewService = new IngrScrapViewService();
		ArrayList<IngrScrapDTO> ingrScrapList = ingrScrapViewService.getIngrScrapList(id);
		request.setAttribute("ingrScrapList", ingrScrapList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/ingrScrapView.jsp");
		
		return forward;
	}

}
