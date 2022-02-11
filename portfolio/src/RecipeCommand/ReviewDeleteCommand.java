package RecipeCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RecipeService.ReviewDeleteService;
import model.ActionForward;

public class ReviewDeleteCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int recipeNo = Integer.parseInt(request.getParameter("recipeNo"));
		
		ReviewDeleteService reviewDeleteService = new ReviewDeleteService();
		boolean deleteSuccess = reviewDeleteService.deleteReview(reviewNo);
		
		if(deleteSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("recipeView.rec?recipeNo=" + recipeNo);
		} else {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('삭제 중 오류가 발생했습니다.'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
