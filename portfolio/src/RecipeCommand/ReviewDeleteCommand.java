package RecipeCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.ReviewDeleteService;
import model.ActionForward;

public class ReviewDeleteCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = null;
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int recipeNo = Integer.parseInt(request.getParameter("recipeNo"));
		int point = Integer.parseInt(request.getParameter("point"));
		
		ReviewDeleteService reviewDeleteService = new ReviewDeleteService();
		boolean deleteSuccess = reviewDeleteService.deleteReview(reviewNo);
		
		// 적립금
		boolean pointSuccess = reviewDeleteService.minusReviewPoint(id, point);
		
		if(deleteSuccess && pointSuccess) {
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
