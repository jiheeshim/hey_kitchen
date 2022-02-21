package RecipeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.MyReviewViewService;
import model.ActionForward;
import model.MyReviewDTO;

public class MyReviewViewCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MyReviewViewService myReviewViewService = new MyReviewViewService();
		ArrayList<MyReviewDTO> myReviewList = myReviewViewService.getMyReviewList(id);
		request.setAttribute("myReviewList", myReviewList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/recipeMyReview.jsp");
		
		return forward;
	}

}
